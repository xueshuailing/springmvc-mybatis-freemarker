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
import com.my.dao.TbClassifyDao;
import com.my.entity.TbClassify;
/**
 * service层
 */
@Service
@Transactional
public class TbClassifyService {
	@Resource
	private TbClassifyDao tbClassifyDao;
	/**
	*保存
	*/
	public void save(TbClassify t) throws Exception{
		this.tbClassifyDao.create(t);
	}
	/**
	*通过查询条件删除
	*/
	public void deleteByParameter(TbClassify t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getName())){
			parameter.addQuery("name", t.getName());
		}
		if(StringUtils.isNotBlank(t.getParentId())){
			parameter.addQuery("parentId", t.getParentId());
		}
		if(StringUtils.isNotBlank(t.getUrl())){
			parameter.addQuery("url", t.getUrl());
		}
		this.tbClassifyDao.delete(parameter);
	}
	/**
	*通过id删除
	*/
	public void deleteById(String id) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id",id);
		this.tbClassifyDao.delete(parameter);
	}
	
	/**
	*通过id修改
	*/
	public void update(TbClassify t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id", t.getId());
		if(StringUtils.isNotBlank(t.getName())){
			parameter.addUpdate("name", t.getName());
		}
		if(StringUtils.isNotBlank(t.getParentId())){
			parameter.addUpdate("parentId", t.getParentId());
		}
		if(StringUtils.isNotBlank(t.getUrl())){
			parameter.addUpdate("url", t.getUrl());
		}
		this.tbClassifyDao.update(parameter);
	}
	/**
	*通过id查询--详情
	*/
	public TbClassify detail(String id) throws Exception{
		SqlParameter parameter = SqlParameter.getSqlParameter();
		if(StringUtils.isNotBlank(id)){
			parameter.addQuery("id", id);			
		}
		Collection<TbClassify> result = this.tbClassifyDao.page(parameter);
		for (TbClassify t : result) {
			return t;
		}
		return null;
	}
	/**
	*通过查询条件查询--分页
	*/
	public Map<String,Object> query(TbClassify t,int pageNo,int pageSize) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getName())){
			parameter.addQuery("name", t.getName());
		}
		if(StringUtils.isNotBlank(t.getParentId())){
			parameter.addQuery("parentId", t.getParentId());
		}
		if(StringUtils.isNotBlank(t.getUrl())){
			parameter.addQuery("url", t.getUrl());
		}
		parameter.addPageNo((pageNo-1)*pageSize);
		parameter.addPageSize(pageSize);
		parameter.addOrder("ID", Order.Desc);//生成默认按照id倒序排
		Collection<TbClassify> list=this.tbClassifyDao.page(parameter);
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
		return tbClassifyDao.totalCount(parameter);
	}
}