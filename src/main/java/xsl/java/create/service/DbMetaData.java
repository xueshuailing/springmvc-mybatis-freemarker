package xsl.java.create.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import xsl.java.create.model.ColumnInfo;
import xsl.java.create.model.TableInfo;

/**
 * User: lxw
 * Date: 14-3-13 下午1:02
 * 统一的获取数据库元数据的抽象类
 */
public abstract class DbMetaData {
    protected Connection connection;
    protected String dbName;


    public DbMetaData(Connection connection,String dbName) {
        this.connection = connection;
        this.dbName=dbName;
    	try {
			connection.setSchema(dbName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    /**
     * 获得数据库中的所有表的元信息
     *
     * @return
     */
    public abstract List<TableInfo> getAllTableInfo();

    /**
     * 取得部分表的元数据信息
     *
     * @param tableNameList
     * @return
     */
    public abstract List<TableInfo> getTableInfo(List<String> tableNameList);

    /**
     * 根据表名，获得表中列的元数据信息
     *
     * @param tableName
     * @return
     */
    public abstract List<ColumnInfo> getColumnInfo(TableInfo tableInfo);

    /**
     * 根据表名得到表的主键元数据信息
     *
     * @param tableName
     * @return
     */
    public abstract String getPrimaryKey(String tableName);
}
