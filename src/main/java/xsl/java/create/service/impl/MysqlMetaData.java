package xsl.java.create.service.impl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xsl.java.create.model.ColumnInfo;
import xsl.java.create.model.TableInfo;
import xsl.java.create.service.DbMetaData;
import xsl.java.create.util.PorcessName;

/**
 * User: lxw
 * Date: 14-3-13 下午1:02
 */
public class MysqlMetaData extends DbMetaData {

    public MysqlMetaData(Connection connection,String dbName) {
        super(connection,dbName);
    }

    /**
     * 获得数据库中的所有表的元信息
     *
     * @return
     */
    @Override
    public List<TableInfo> getAllTableInfo() {
        ResultSet rs = null;
        List<TableInfo> tableInfoList = new ArrayList<TableInfo>();
        try {
            DatabaseMetaData dbmd = connection.getMetaData();
            rs = dbmd.getTables(dbName, null, null, new String[]{"TABLE"});
            while (rs.next()) {
                TableInfo tableInfo = new TableInfo();
                tableInfo.setTableName(rs.getString("TABLE_NAME"));
                tableInfo.setTableRemark(rs.getString("REMARKS"));
                tableInfo.setTableRemark(getTableComment(rs.getString("TABLE_NAME"),dbName));
                tableInfo.setTableClassName(PorcessName.getJavaClassName(tableInfo.getTableName()));
                tableInfo.setTablePk(getPrimaryKey(tableInfo.getTableName()));
                tableInfo.setTableColumns(getColumnInfo(tableInfo));
                tableInfoList.add(tableInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return tableInfoList;
    }


    /**
     * 获取表的注释
     * @param tableName
     * @param schema
     * @return
     */
    private String getTableComment(String tableName,String schema){
        ResultSet rs=null;
        String tableComment="";
        try {
            PreparedStatement pstm=connection.prepareStatement("SELECT t.table_comment FROM information_schema.tables t WHERE t.table_schema =? AND t.table_name=?");
            pstm.setString(1,schema);
            pstm.setString(2,tableName);
            rs=pstm.executeQuery();
            if(rs.next())
            {
                tableComment=rs.getString("table_comment");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs!=null)
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tableComment;
    }

    /**
     * 取得部分表的元数据信息
     *
     * @param tableNameList
     * @return
     */
    @Override
    public List<TableInfo> getTableInfo(List<String> tableNameList) {
        return null;
    }

    /**
     * 根据表名，获得表中列的元数据信息
     *
     * @param tableInfo
     * @return
     */
    @Override
    public List<ColumnInfo> getColumnInfo(TableInfo tableInfo) {
        List<ColumnInfo> columnInfoList = new ArrayList<ColumnInfo>();
        ResultSet rs = null;
        ResultSet tableRs = null;
        int index = 1;

        try {
            DatabaseMetaData dbmd = connection.getMetaData();
            PreparedStatement pst = connection.prepareStatement("select * from " + tableInfo.getTableName() + " where 1=2");
            tableRs = pst.executeQuery();
            rs = dbmd.getColumns(dbName, null, tableInfo.getTableName(), null);
            ResultSetMetaData meta = tableRs.getMetaData();
            while (rs.next()) {
                ColumnInfo columnInfo = new ColumnInfo();
                columnInfo.setJdbcName(rs.getString("COLUMN_NAME"));
                columnInfo.setJdbcType(meta.getColumnTypeName(index));
                columnInfo.setJavaName(PorcessName.replaceUnderlineAndfirstToUpper(columnInfo.getJdbcName().toLowerCase()));
                columnInfo.setJavaType(PorcessName.getJavaType(meta.getColumnClassName(index)));
                columnInfo.setRemark(rs.getString("REMARKS"));
                columnInfo.setJdbcNullable(meta.isNullable(index)==ResultSetMetaData.columnNullable);
                columnInfo.setJdbcScale(meta.getScale(index));
                columnInfo.setJdbcPrecision(meta.getPrecision(index));

                columnInfo.setDefaultValue(rs.getString("COLUMN_DEF"));
                if(pkName.equals(columnInfo.getJdbcName()))
                {
                    columnInfo.setJdbcIsKey(true);
                    tableInfo.setTablePkInfo(columnInfo);
                }else{
                    columnInfo.setJdbcIsKey(false);
                }
                columnInfoList.add(columnInfo);
                index++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return columnInfoList;
    }

    /**
     * 根据表名得到表的主键元数据信息
     *
     * @param tableName
     * @return
     */
    String pkName = "";
    @Override
    public String getPrimaryKey(String tableName) {
        ResultSet rs = null;

        try {
            DatabaseMetaData dbmd = connection.getMetaData();
            rs = dbmd.getPrimaryKeys(dbName, null, tableName);
            if (rs.next()) {
                pkName = rs.getString("COLUMN_NAME");
            } else {
            	pkName="没有主键";
                throw new RuntimeException("表" + tableName + "没有主键");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return pkName;
    }
}
