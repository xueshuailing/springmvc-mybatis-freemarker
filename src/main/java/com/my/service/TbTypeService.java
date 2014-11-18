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
import com.my.dao.TbTypeDao;
import com.my.entity.TbType;
/**
 * 收入、支出类型字典表service层
 */
@Service
@Transactional
public class TbTypeService {
	@Resource
	private TbTypeDao tbTypeDao;
	/**
	*保存
	*/
	public void save(TbType t) throws Exception{
		this.tbTypeDao.create(t);
	}
	/**
	*通过查询条件删除
	*/
	public void deleteByParameter(TbType t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getType())){
			parameter.addQuery("type", t.getType());
		}
		if(StringUtils.isNotBlank(t.getName())){
			parameter.addQuery("name", t.getName());
		}
		if(StringUtils.isNotBlank(t.getUserId())){
			parameter.addQuery("userId", t.getUserId());
		}
		if(StringUtils.isNotBlank(t.getCreateDate())){
			parameter.addQuery("createDate", t.getCreateDate());
		}
		this.tbTypeDao.delete(parameter);
	}
	/**
	*通过id删除
	*/
	public void deleteById(String id) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id",id);
		this.tbTypeDao.delete(parameter);
	}
	
	/**
	*通过id修改
	*/
	public void update(TbType t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id", t.getId());
		if(StringUtils.isNotBlank(t.getType())){
			parameter.addUpdate("type", t.getType());
		}
		if(StringUtils.isNotBlank(t.getName())){
			parameter.addUpdate("name", t.getName());
		}
		if(StringUtils.isNotBlank(t.getUserId())){
			parameter.addUpdate("userId", t.getUserId());
		}
		if(StringUtils.isNotBlank(t.getCreateDate())){
			parameter.addUpdate("createDate", t.getCreateDate());
		}
		this.tbTypeDao.update(parameter);
	}
	/**
	*通过id查询--详情
	*/
	public TbType detail(String id) throws Exception{
		SqlParameter parameter = SqlParameter.getSqlParameter();
		if(StringUtils.isNotBlank(id)){
			parameter.addQuery("id", id);			
		}
		Collection<TbType> result = this.tbTypeDao.page(parameter);
		for (TbType t : result) {
			return t;
		}
		return null;
	}
	/**
	*通过查询条件查询--分页
	*/
	public Map<String,Object> query(TbType t,int pageNo,int pageSize) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getType())){
			parameter.addQuery("type", t.getType());
		}
		if(StringUtils.isNotBlank(t.getName())){
			parameter.addQuery("name", t.getName());
		}
		if(StringUtils.isNotBlank(t.getUserId())){
			parameter.addQuery("userId", t.getUserId());
		}
		if(StringUtils.isNotBlank(t.getCreateDate())){
			parameter.addQuery("createDate", t.getCreateDate());
		}
		parameter.addPageNo((pageNo-1)*pageSize);
		parameter.addPageSize(pageSize);
		parameter.addOrder("ID", Order.Desc);//生成默认按照id倒序排
		Collection<TbType> list=this.tbTypeDao.page(parameter);
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
		return tbTypeDao.totalCount(parameter);
	}
}