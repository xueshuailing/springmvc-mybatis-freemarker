<?xml version="1.0" encoding="UTF-8"?>  
<!DOCTYPE mapper PUBLIC "-//ibatis.apache.org//DTD Mapper 3.0//EN" "http://ibatis.apache.org/dtd/ibatis-3-mapper.dtd">
<mapper namespace="${tableInfo.tableClassName}">
	<insert id="${tableInfo.tableClassName}_create" useGeneratedKeys="true" keyProperty="id" parameterType="${tableInfo.tableClassName}">
		 
		INSERT INTO ${tableInfo.tableName}
		(
			 <#list tableInfo.tableColumns as columnInfo>
            	${columnInfo.jdbcName}<#if columnInfo_has_next>,</#if>
       		 </#list>
		)
		VALUES
		(
			<#list tableInfo.tableColumns as columnInfo>
            ${"#"}{${columnInfo.javaName},<#if columnInfo.jdbcType=="INT">jdbcType=INTEGER<#elseif columnInfo.jdbcType=="DATETIME">jdbcType=DATE<#else>jdbcType=${columnInfo.jdbcType?upper_case}</#if>}<#if columnInfo_has_next>,</#if>
        	</#list>
		)
	</insert>
	
	<select id="${tableInfo.tableClassName}_read" parameterType="map" resultMap="${tableInfo.tableClassName}ResultMap">
		select * from ${tableInfo.tableName}
			<include refid="${tableInfo.tableClassName}FindCriteria" />
	</select>
	
	<select id="${tableInfo.tableClassName}_count" parameterType="map" resultType="long">
		select count(0) from ${tableInfo.tableName}
			<include refid="${tableInfo.tableClassName}FindCriteria" />
	</select>
	
	<select id="${tableInfo.tableClassName}_page" parameterType="map" resultMap="${tableInfo.tableClassName}ResultMap">
		select * from ${tableInfo.tableName}
		<include refid="${tableInfo.tableClassName}FindCriteria" />
		<include refid="Public.OrderCriteria" />
		<include refid="Public.PageCriteria" />
	</select>
 
	<delete id="${tableInfo.tableClassName}_delete" parameterType="map">
		delete from ${tableInfo.tableName} 
		<include refid="${tableInfo.tableClassName}FindCriteria" />
	</delete>
	
	<update id="${tableInfo.tableClassName}_update" parameterType="map">
		update ${tableInfo.tableName} 
		<include refid="${tableInfo.tableClassName}UpdateCriteria"/>
		<include refid="${tableInfo.tableClassName}FindCriteria"/>
	</update>
</mapper> 