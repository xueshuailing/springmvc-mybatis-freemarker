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
import com.my.dao.CityDao;
import com.my.entity.City;
/**
 * service层
 */
@Service
@Transactional
public class CityService {
	@Resource
	private CityDao cityDao;
	/**
	*保存
	*/
	public void save(City t) throws Exception{
		this.cityDao.create(t);
	}
	/**
	*通过查询条件删除
	*/
	public void deleteByParameter(City t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getCityId())){
			parameter.addQuery("cityId", t.getCityId());
		}
		if(StringUtils.isNotBlank(t.getCityName())){
			parameter.addQuery("cityName", t.getCityName());
		}
		if(StringUtils.isNotBlank(t.getProId())){
			parameter.addQuery("proId", t.getProId());
		}
		if(StringUtils.isNotBlank(t.getCitySort())){
			parameter.addQuery("citySort", t.getCitySort());
		}
		this.cityDao.delete(parameter);
	}
	/**
	*通过id删除
	*/
	public void deleteById(String id) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id",id);
		this.cityDao.delete(parameter);
	}
	
	/**
	*通过id修改
	*/
	public void update(City t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id", t.getId());
		if(StringUtils.isNotBlank(t.getCityId())){
			parameter.addUpdate("cityId", t.getCityId());
		}
		if(StringUtils.isNotBlank(t.getCityName())){
			parameter.addUpdate("cityName", t.getCityName());
		}
		if(StringUtils.isNotBlank(t.getProId())){
			parameter.addUpdate("proId", t.getProId());
		}
		if(StringUtils.isNotBlank(t.getCitySort())){
			parameter.addUpdate("citySort", t.getCitySort());
		}
		this.cityDao.update(parameter);
	}
	/**
	*通过id查询--详情
	*/
	public City detail(String id) throws Exception{
		SqlParameter parameter = SqlParameter.getSqlParameter();
		if(StringUtils.isNotBlank(id)){
			parameter.addQuery("id", id);			
		}
		Collection<City> result = this.cityDao.page(parameter);
		for (City t : result) {
			return t;
		}
		return null;
	}
	/**
	*通过查询条件查询--分页
	*/
	public Map<String,Object> query(City t,int pageNo,int pageSize) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getCityId())){
			parameter.addQuery("cityId", t.getCityId());
		}
		if(StringUtils.isNotBlank(t.getCityName())){
			parameter.addQuery("cityName", t.getCityName());
		}
		if(StringUtils.isNotBlank(t.getProId())){
			parameter.addQuery("proId", t.getProId());
		}
		if(StringUtils.isNotBlank(t.getCitySort())){
			parameter.addQuery("citySort", t.getCitySort());
		}
		parameter.addPageNo((pageNo-1)*pageSize);
		parameter.addPageSize(pageSize);
		parameter.addOrder("ID", Order.Desc);//生成默认按照id倒序排
		Collection<City> list=this.cityDao.page(parameter);
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
		return cityDao.totalCount(parameter);
	}
}