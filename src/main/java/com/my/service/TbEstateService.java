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
import com.my.dao.TbEstateDao;
import com.my.entity.TbEstate;
/**
 * service层
 */
@Service
@Transactional
public class TbEstateService {
	@Resource
	private TbEstateDao tbEstateDao;
	/**
	*保存
	*/
	public void save(TbEstate t) throws Exception{
		this.tbEstateDao.create(t);
	}
	/**
	*通过查询条件删除
	*/
	public void deleteByParameter(TbEstate t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getCreateDate())){
			parameter.addQuery("createDate", t.getCreateDate());
		}
		if(StringUtils.isNotBlank(t.getName())){
			parameter.addQuery("name", t.getName());
		}
		if(StringUtils.isNotBlank(t.getIntroduction())){
			parameter.addQuery("introduction", t.getIntroduction());
		}
		if(StringUtils.isNotBlank(t.getAddress())){
			parameter.addQuery("address", t.getAddress());
		}
		if(StringUtils.isNotBlank(t.getProId())){
			parameter.addQuery("proId", t.getProId());
		}
		if(StringUtils.isNotBlank(t.getCountId())){
			parameter.addQuery("countId", t.getCountId());
		}
		if(StringUtils.isNotBlank(t.getCityId())){
			parameter.addQuery("cityId", t.getCityId());
		}
		this.tbEstateDao.delete(parameter);
	}
	/**
	*通过id删除
	*/
	public void deleteById(String id) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id",id);
		this.tbEstateDao.delete(parameter);
	}
	
	/**
	*通过id修改
	*/
	public void update(TbEstate t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id", t.getId());
		if(StringUtils.isNotBlank(t.getCreateDate())){
			parameter.addUpdate("createDate", t.getCreateDate());
		}
		if(StringUtils.isNotBlank(t.getName())){
			parameter.addUpdate("name", t.getName());
		}
		if(StringUtils.isNotBlank(t.getIntroduction())){
			parameter.addUpdate("introduction", t.getIntroduction());
		}
		if(StringUtils.isNotBlank(t.getAddress())){
			parameter.addUpdate("address", t.getAddress());
		}
		if(StringUtils.isNotBlank(t.getProId())){
			parameter.addUpdate("proId", t.getProId());
		}
		if(StringUtils.isNotBlank(t.getCountId())){
			parameter.addUpdate("countId", t.getCountId());
		}
		if(StringUtils.isNotBlank(t.getCityId())){
			parameter.addUpdate("cityId", t.getCityId());
		}
		this.tbEstateDao.update(parameter);
	}
	/**
	*通过id查询--详情
	*/
	public TbEstate detail(String id) throws Exception{
		SqlParameter parameter = SqlParameter.getSqlParameter();
		if(StringUtils.isNotBlank(id)){
			parameter.addQuery("id", id);			
		}
		Collection<TbEstate> result = this.tbEstateDao.page(parameter);
		for (TbEstate t : result) {
			return t;
		}
		return null;
	}
	/**
	*通过查询条件查询--分页
	*/
	public Map<String,Object> query(TbEstate t,int pageNo,int pageSize) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getCreateDate())){
			parameter.addQuery("createDate", t.getCreateDate());
		}
		if(StringUtils.isNotBlank(t.getName())){
			parameter.addQuery("name", t.getName());
		}
		if(StringUtils.isNotBlank(t.getIntroduction())){
			parameter.addQuery("introduction", t.getIntroduction());
		}
		if(StringUtils.isNotBlank(t.getAddress())){
			parameter.addQuery("address", t.getAddress());
		}
		if(StringUtils.isNotBlank(t.getProId())){
			parameter.addQuery("proId", t.getProId());
		}
		if(StringUtils.isNotBlank(t.getCountId())){
			parameter.addQuery("countId", t.getCountId());
		}
		if(StringUtils.isNotBlank(t.getCityId())){
			parameter.addQuery("cityId", t.getCityId());
		}
		parameter.addPageNo((pageNo-1)*pageSize);
		parameter.addPageSize(pageSize);
		parameter.addOrder("ID", Order.Desc);//生成默认按照id倒序排
		Collection<TbEstate> list=this.tbEstateDao.page(parameter);
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
		return tbEstateDao.totalCount(parameter);
	}
}