package xsl.java.create.model;

/**
 * User: lxw
 * Date: 14-3-12 下午12:33
 * 列的元数据信息表
 */
public class ColumnInfo {

    private String javaName;//对应的java变量名
    private String javaType;//对应的java类型
    private String jdbcName;//DB中的列名
    private String jdbcType;//DB中的类型
    private int jdbcPrecision;//长度
    private int jdbcScale; //小数位数
    private boolean jdbcNullable;//是否可以为null
    private boolean jdbcIsKey;//是否是主键
    private String defaultValue; //默认值
    private String remark;//注释

    public String getJavaName() {
        return javaName;
    }

    public void setJavaName(String javaName) {
        this.javaName = javaName;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getJdbcName() {
        return jdbcName;
    }

    public void setJdbcName(String jdbcName) {
        this.jdbcName = jdbcName;
    }

    public String getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getJdbcPrecision() {
        return jdbcPrecision;
    }

    public void setJdbcPrecision(int jdbcPrecision) {
        this.jdbcPrecision = jdbcPrecision;
    }

    public int getJdbcScale() {
        return jdbcScale;
    }

    public void setJdbcScale(int jdbcScale) {
        this.jdbcScale = jdbcScale;
    }

    public boolean isJdbcNullable() {
        return jdbcNullable;
    }

    public void setJdbcNullable(boolean jdbcNullable) {
        this.jdbcNullable = jdbcNullable;
    }

    public boolean isJdbcIsKey() {
        return jdbcIsKey;
    }

    public void setJdbcIsKey(boolean jdbcIsKey) {
        this.jdbcIsKey = jdbcIsKey;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public String toString() {
        return "ColumnInfo{" +
                "javaName='" + javaName + '\'' +
                ", javaType='" + javaType + '\'' +
                ", jdbcName='" + jdbcName + '\'' +
                ", jdbcType='" + jdbcType + '\'' +
                ", jdbcPrecision='" + jdbcPrecision + '\'' +
                ", jdbcScale='" + jdbcScale + '\'' +
                ", jdbcNullable='" + jdbcNullable + '\'' +
                ", jdbcIsKey=" + jdbcIsKey +
                ", defaultValue='" + defaultValue + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
