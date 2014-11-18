<?xml version="1.0" encoding="UTF-8"?>  
<!DOCTYPE mapper PUBLIC "-//ibatis.apache.org//DTD Mapper 3.0//EN" "http://ibatis.apache.org/dtd/ibatis-3-mapper.dtd">
<mapper namespace="${tableInfo.tableClassName}">
	<resultMap type="${tableInfo.tableClassName}" id="${tableInfo.tableClassName}ResultMap">
		<#list tableInfo.tableColumns as columnInfo>
            	<result column="${columnInfo.jdbcName}" property="${columnInfo.javaName}" />
       	</#list>
	</resultMap>

	<sql id="${tableInfo.tableClassName}FindCriteria">
		<where>
		<#list tableInfo.tableColumns as columnInfo>
            <if test="query${columnInfo.javaName?cap_first} != null and query${columnInfo.javaName?cap_first} != ''">
				and ${columnInfo.jdbcName} = ${"#"}{query${columnInfo.javaName?cap_first}}
			</if>
       	</#list>
		</where>
	</sql>

	<sql id="${tableInfo.tableClassName}UpdateCriteria">
		<set>
		<#list tableInfo.tableColumns as columnInfo>
            <if test="update${columnInfo.javaName?cap_first} != null and update${columnInfo.javaName?cap_first} != ''">
				 ${columnInfo.jdbcName} =${"#"}{update${columnInfo.javaName?cap_first}},
			</if>
       	</#list>
		</set>
	</sql>
</mapper> 