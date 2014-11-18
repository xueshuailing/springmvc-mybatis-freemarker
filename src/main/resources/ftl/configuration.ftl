<?xml version="1.0" encoding="UTF-8"?>  
<!DOCTYPE configuration PUBLIC "-//ibatis.apache.org//DTD Config 3.0//EN" "http://ibatis.apache.org/dtd/ibatis-3-config.dtd">
<configuration>
	  <typeAliases>
	  	 <#list infoList as table>
	  		<!-- ${table.tableRemark}mybatis别名 -->
    		<typeAlias alias="${table.tableClassName}" type="${packageName}${"."}${table.tableClassName}"/>
	 	</#list>
	  </typeAliases>
	<mappers>
		 <#list infoList as table>
	  		<!-- ${table.tableRemark} 配置文件路径-->
    		 <mapper resource="configure/mybatis/orm/mapper/${table.tableClassName}.xml"/>
	  		 <mapper resource="configure/mybatis/orm/${table.tableClassName}.xml"/>
	  		 
	  		 
	 	</#list>
	 	<!-- 公用 配置文件路径-->
	  	<mapper resource="configure/mybatis/Public.xml" />
	 </mappers>
</configuration>