package xsl.java.create.model;

import java.io.Serializable;
import java.util.List;

/**
 * User: lxw
 * Date: 14-3-12 下午12:29
 * 表的元数据信息
 */
public class TableInfo implements Serializable {
    private String tablePk;
    private String tableName;
    private String tableClassName;
    private String tableRemark;
    private ColumnInfo tablePkInfo;
    private List<ColumnInfo> tableColumns;

    public String getTablePk() {
        return tablePk;
    }

    public void setTablePk(String tablePk) {
        this.tablePk = tablePk;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableRemark() {
        return tableRemark;
    }

    public void setTableRemark(String tableRemark) {
        this.tableRemark = tableRemark;
    }

    public String getTableClassName() {
        return tableClassName;
    }

    public void setTableClassName(String tableClassName) {
        this.tableClassName = tableClassName;
    }

    public List<ColumnInfo> getTableColumns() {
        return tableColumns;
    }

    public void setTableColumns(List<ColumnInfo> tableColumns) {
        this.tableColumns = tableColumns;
    }

    public ColumnInfo getTablePkInfo() {
        return tablePkInfo;
    }

    public void setTablePkInfo(ColumnInfo tablePkInfo) {
        this.tablePkInfo = tablePkInfo;
    }
}
