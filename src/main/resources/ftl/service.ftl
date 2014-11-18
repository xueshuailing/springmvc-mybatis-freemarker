package ${packageName};
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.gitchina.framework.commons.dao.support.Order;
import org.gitchina.framework.commons.dao.support.SqlParameter;
import org.gitchina.framework.commons.utils.Pager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ${daoPackageName}${"."}${tableInfo.getTableClassName()}Dao;
import ${entityPackageName}${"."}${tableInfo.getTableClassName()};
/**
 * ${tableInfo.tableRemark}service层
 */
@Service
@Transactional
public class ${tableInfo.getTableClassName()}Service {
	@Resource
	private ${tableInfo.getTableClassName()}Dao ${tableInfo.getTableClassName()?uncap_first}Dao;
	/**
	*保存
	*/
	public void save(${tableInfo.getTableClassName()} t) throws Exception{
		this.${tableInfo.getTableClassName()?uncap_first}Dao.create(t);
	}
	/**
	*通过查询条件删除
	*/
	public void deleteByParameter(${tableInfo.getTableClassName()} t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		<#list tableInfo.tableColumns as columnInfo>
			<#if columnInfo.javaName != "id">
		if(StringUtils.isNotBlank(t.get${columnInfo.javaName?cap_first}())){
			parameter.addQuery("${columnInfo.javaName}", t.get${columnInfo.javaName?cap_first}());
		}
			</#if>
		</#list>
		this.${tableInfo.getTableClassName()?uncap_first}Dao.delete(parameter);
	}
	/**
	*通过id删除
	*/
	public void deleteById(String id) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id",id);
		this.${tableInfo.getTableClassName()?uncap_first}Dao.delete(parameter);
	}
	
	/**
	*通过id修改
	*/
	public void update(${tableInfo.getTableClassName()} t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id", t.getId());
		<#list tableInfo.tableColumns as columnInfo>
		<#if columnInfo.javaName != "id">
		if(StringUtils.isNotBlank(t.get${columnInfo.javaName?cap_first}())){
			parameter.addUpdate("${columnInfo.javaName}", t.get${columnInfo.javaName?cap_first}());
		}
		</#if>
		</#list>
		this.${tableInfo.getTableClassName()?uncap_first}Dao.update(parameter);
	}
	/**
	*通过id查询--详情
	*/
	public ${tableInfo.getTableClassName()} detail(String id) throws Exception{
		SqlParameter parameter = SqlParameter.getSqlParameter();
		if(StringUtils.isNotBlank(id)){
			parameter.addQuery("id", id);			
		}
		Collection<${tableInfo.getTableClassName()}> result = this.${tableInfo.getTableClassName()?uncap_first}Dao.page(parameter);
		for (${tableInfo.getTableClassName()} t : result) {
			return t;
		}
		return null;
	}
	/**
	*通过查询条件查询--分页
	*/
	public Map<String,Object> query(${tableInfo.getTableClassName()} t,int pageNo,int pageSize) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		<#list tableInfo.tableColumns as columnInfo>
		<#if columnInfo.javaName != "id">
		if(StringUtils.isNotBlank(t.get${columnInfo.javaName?cap_first}())){
			parameter.addQuery("${columnInfo.javaName}", t.get${columnInfo.javaName?cap_first}());
		}
		</#if>
		</#list>
		parameter.addPageNo((pageNo-1)*pageSize);
		parameter.addPageSize(pageSize);
		parameter.addOrder("ID", Order.Desc);//生成默认按照id倒序排
		Collection<${tableInfo.getTableClassName()}> list=this.${tableInfo.getTableClassName()?uncap_first}Dao.page(parameter);
		Pager page=new Pager(totalCount(parameter),pageNo,pageSize);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("list",list);
		map.put("page",page);
		return map;
	}
	/**
	 * 查询总数
	 * @param parameter
	 * @return
	 */
	private long totalCount(SqlParameter parameter ) {
		return ${tableInfo.getTableClassName()?uncap_first}Dao.totalCount(parameter);
	}
}