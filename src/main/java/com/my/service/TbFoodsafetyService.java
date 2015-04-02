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
import com.my.dao.TbFoodsafetyDao;
import com.my.entity.TbFoodsafety;
/**
 * service层
 */
@Service
@Transactional
public class TbFoodsafetyService {
	@Resource
	private TbFoodsafetyDao tbFoodsafetyDao;
	/**
	*保存
	*/
	public void save(TbFoodsafety t) throws Exception{
		this.tbFoodsafetyDao.create(t);
	}
	/**
	*通过查询条件删除
	*/
	public void deleteByParameter(TbFoodsafety t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getTitle())){
			parameter.addQuery("title", t.getTitle());
		}
		if(StringUtils.isNotBlank(t.getCreateDate())){
			parameter.addQuery("createDate", t.getCreateDate());
		}
		if(StringUtils.isNotBlank(t.getContent())){
			parameter.addQuery("content", t.getContent());
		}
		this.tbFoodsafetyDao.delete(parameter);
	}
	/**
	*通过id删除
	*/
	public void deleteById(String id) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id",id);
		this.tbFoodsafetyDao.delete(parameter);
	}
	
	/**
	*通过id修改
	*/
	public void update(TbFoodsafety t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id", t.getId());
		if(StringUtils.isNotBlank(t.getTitle())){
			parameter.addUpdate("title", t.getTitle());
		}
		if(StringUtils.isNotBlank(t.getCreateDate())){
			parameter.addUpdate("createDate", t.getCreateDate());
		}
		if(StringUtils.isNotBlank(t.getContent())){
			parameter.addUpdate("content", t.getContent());
		}
		this.tbFoodsafetyDao.update(parameter);
	}
	/**
	*通过id查询--详情
	*/
	public TbFoodsafety detail(String id) throws Exception{
		SqlParameter parameter = SqlParameter.getSqlParameter();
		if(StringUtils.isNotBlank(id)){
			parameter.addQuery("id", id);			
		}
		Collection<TbFoodsafety> result = this.tbFoodsafetyDao.page(parameter);
		for (TbFoodsafety t : result) {
			return t;
		}
		return null;
	}
	/**
	*通过查询条件查询--分页
	*/
	public Map<String,Object> query(TbFoodsafety t,int pageNo,int pageSize) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getTitle())){
			parameter.addQuery("title", t.getTitle());
		}
		if(StringUtils.isNotBlank(t.getCreateDate())){
			parameter.addQuery("createDate", t.getCreateDate());
		}
		if(StringUtils.isNotBlank(t.getContent())){
			parameter.addQuery("content", t.getContent());
		}
		parameter.addPageNo((pageNo-1)*pageSize);
		parameter.addPageSize(pageSize);
		parameter.addOrder("ID", Order.Desc);//生成默认按照id倒序排
		Collection<TbFoodsafety> list=this.tbFoodsafetyDao.page(parameter);
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
		return tbFoodsafetyDao.totalCount(parameter);
	}
}