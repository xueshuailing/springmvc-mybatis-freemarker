package com.my.service;
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
import com.my.dao.TbVersionDao;
import com.my.entity.TbVersion;
/**
 * 版本控制表service层
 */
@Service
@Transactional
public class TbVersionService {
	@Resource
	private TbVersionDao tbVersionDao;
	/**
	*保存
	*/
	public void save(TbVersion t) throws Exception{
		this.tbVersionDao.create(t);
	}
	/**
	*通过查询条件删除
	*/
	public void deleteByParameter(TbVersion t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getVersionCode())){
			parameter.addQuery("versionCode", t.getVersionCode());
		}
		if(StringUtils.isNotBlank(t.getVersionName())){
			parameter.addQuery("versionName", t.getVersionName());
		}
		if(StringUtils.isNotBlank(t.getVersionUpdate())){
			parameter.addQuery("versionUpdate", t.getVersionUpdate());
		}
		if(StringUtils.isNotBlank(t.getVersionSize())){
			parameter.addQuery("versionSize", t.getVersionSize());
		}
		if(StringUtils.isNotBlank(t.getVersionUrl())){
			parameter.addQuery("versionUrl", t.getVersionUrl());
		}
		if(StringUtils.isNotBlank(t.getVersionTime())){
			parameter.addQuery("versionTime", t.getVersionTime());
		}
		if(StringUtils.isNotBlank(t.getVersionType())){
			parameter.addQuery("versionType", t.getVersionType());
		}
		this.tbVersionDao.delete(parameter);
	}
	/**
	*通过id删除
	*/
	public void deleteById(String id) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id",id);
		this.tbVersionDao.delete(parameter);
	}
	
	/**
	*通过id修改
	*/
	public void update(TbVersion t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id", t.getId());
		if(StringUtils.isNotBlank(t.getVersionCode())){
			parameter.addUpdate("versionCode", t.getVersionCode());
		}
		if(StringUtils.isNotBlank(t.getVersionName())){
			parameter.addUpdate("versionName", t.getVersionName());
		}
		if(StringUtils.isNotBlank(t.getVersionUpdate())){
			parameter.addUpdate("versionUpdate", t.getVersionUpdate());
		}
		if(StringUtils.isNotBlank(t.getVersionSize())){
			parameter.addUpdate("versionSize", t.getVersionSize());
		}
		if(StringUtils.isNotBlank(t.getVersionUrl())){
			parameter.addUpdate("versionUrl", t.getVersionUrl());
		}
		if(StringUtils.isNotBlank(t.getVersionTime())){
			parameter.addUpdate("versionTime", t.getVersionTime());
		}
		if(StringUtils.isNotBlank(t.getVersionType())){
			parameter.addUpdate("versionType", t.getVersionType());
		}
		this.tbVersionDao.update(parameter);
	}
	/**
	*通过id查询--详情
	*/
	public TbVersion detail(String id) throws Exception{
		SqlParameter parameter = SqlParameter.getSqlParameter();
		if(StringUtils.isNotBlank(id)){
			parameter.addQuery("id", id);			
		}
		Collection<TbVersion> result = this.tbVersionDao.page(parameter);
		for (TbVersion t : result) {
			return t;
		}
		return null;
	}
	/**
	*通过查询条件查询--分页
	*/
	public Map<String,Object> query(TbVersion t,int pageNo,int pageSize) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getVersionCode())){
			parameter.addQuery("versionCode", t.getVersionCode());
		}
		if(StringUtils.isNotBlank(t.getVersionName())){
			parameter.addQuery("versionName", t.getVersionName());
		}
		if(StringUtils.isNotBlank(t.getVersionUpdate())){
			parameter.addQuery("versionUpdate", t.getVersionUpdate());
		}
		if(StringUtils.isNotBlank(t.getVersionSize())){
			parameter.addQuery("versionSize", t.getVersionSize());
		}
		if(StringUtils.isNotBlank(t.getVersionUrl())){
			parameter.addQuery("versionUrl", t.getVersionUrl());
		}
		if(StringUtils.isNotBlank(t.getVersionTime())){
			parameter.addQuery("versionTime", t.getVersionTime());
		}
		if(StringUtils.isNotBlank(t.getVersionType())){
			parameter.addQuery("versionType", t.getVersionType());
		}
		parameter.addPageNo((pageNo-1)*pageSize);
		parameter.addPageSize(pageSize);
		parameter.addOrder("ID", Order.Desc);//生成默认按照id倒序排
		Collection<TbVersion> list=this.tbVersionDao.page(parameter);
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
		return tbVersionDao.totalCount(parameter);
	}
}