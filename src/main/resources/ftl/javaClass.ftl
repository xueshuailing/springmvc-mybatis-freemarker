package ${packageName};
import org.gitchina.framework.commons.dao.entity.Entity;
/**
 * ${tableInfo.tableRemark}
 */
public class ${tableInfo.getTableClassName()} extends Entity{
<#list tableInfo.tableColumns as columnInfo>
<#if columnInfo.javaName != "id">
    /**${columnInfo.remark}*/
    private ${columnInfo.javaType} ${columnInfo.javaName};
</#if>
</#list>
<#list tableInfo.tableColumns as columnInfo>
	<#if columnInfo.javaName != "id">
		public ${columnInfo.javaType} get${columnInfo.javaName?cap_first}() {
        return ${columnInfo.javaName};
    }

    public void set${columnInfo.javaName?cap_first}(${columnInfo.javaType} ${columnInfo.javaName}) {
        this.${columnInfo.javaName} = ${columnInfo.javaName};
    }
	</#if>
</#list>
}