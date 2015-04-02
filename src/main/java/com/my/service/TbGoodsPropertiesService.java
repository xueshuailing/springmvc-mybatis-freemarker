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
import com.my.dao.TbGoodsPropertiesDao;
import com.my.entity.TbGoodsProperties;
/**
 * service层
 */
@Service
@Transactional
public class TbGoodsPropertiesService {
	@Resource
	private TbGoodsPropertiesDao tbGoodsPropertiesDao;
	/**
	*保存
	*/
	public void save(TbGoodsProperties t) throws Exception{
		this.tbGoodsPropertiesDao.create(t);
	}
	/**
	*通过查询条件删除
	*/
	public void deleteByParameter(TbGoodsProperties t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getName())){
			parameter.addQuery("name", t.getName());
		}
		if(StringUtils.isNotBlank(t.getIsMany())){
			parameter.addQuery("isMany", t.getIsMany());
		}
		if(StringUtils.isNotBlank(t.getParentId())){
			parameter.addQuery("parentId", t.getParentId());
		}
		if(StringUtils.isNotBlank(t.getIsPublic())){
			parameter.addQuery("isPublic", t.getIsPublic());
		}
		this.tbGoodsPropertiesDao.delete(parameter);
	}
	/**
	*通过id删除
	*/
	public void deleteById(String id) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id",id);
		this.tbGoodsPropertiesDao.delete(parameter);
	}
	
	/**
	*通过id修改
	*/
	public void update(TbGoodsProperties t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id", t.getId());
		if(StringUtils.isNotBlank(t.getName())){
			parameter.addUpdate("name", t.getName());
		}
		if(StringUtils.isNotBlank(t.getIsMany())){
			parameter.addUpdate("isMany", t.getIsMany());
		}
		if(StringUtils.isNotBlank(t.getParentId())){
			parameter.addUpdate("parentId", t.getParentId());
		}
		if(StringUtils.isNotBlank(t.getIsPublic())){
			parameter.addUpdate("isPublic", t.getIsPublic());
		}
		this.tbGoodsPropertiesDao.update(parameter);
	}
	/**
	*通过id查询--详情
	*/
	public TbGoodsProperties detail(String id) throws Exception{
		SqlParameter parameter = SqlParameter.getSqlParameter();
		if(StringUtils.isNotBlank(id)){
			parameter.addQuery("id", id);			
		}
		Collection<TbGoodsProperties> result = this.tbGoodsPropertiesDao.page(parameter);
		for (TbGoodsProperties t : result) {
			return t;
		}
		return null;
	}
	/**
	*通过查询条件查询--分页
	*/
	public Map<String,Object> query(TbGoodsProperties t,int pageNo,int pageSize) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getName())){
			parameter.addQuery("name", t.getName());
		}
		if(StringUtils.isNotBlank(t.getIsMany())){
			parameter.addQuery("isMany", t.getIsMany());
		}
		if(StringUtils.isNotBlank(t.getParentId())){
			parameter.addQuery("parentId", t.getParentId());
		}
		if(StringUtils.isNotBlank(t.getIsPublic())){
			parameter.addQuery("isPublic", t.getIsPublic());
		}
		parameter.addPageNo((pageNo-1)*pageSize);
		parameter.addPageSize(pageSize);
		parameter.addOrder("ID", Order.Desc);//生成默认按照id倒序排
		Collection<TbGoodsProperties> list=this.tbGoodsPropertiesDao.page(parameter);
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
		return tbGoodsPropertiesDao.totalCount(parameter);
	}
}