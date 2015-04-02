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
import com.my.dao.TbEstateInfoDao;
import com.my.entity.TbEstateInfo;
/**
 * service层
 */
@Service
@Transactional
public class TbEstateInfoService {
	@Resource
	private TbEstateInfoDao tbEstateInfoDao;
	/**
	*保存
	*/
	public void save(TbEstateInfo t) throws Exception{
		this.tbEstateInfoDao.create(t);
	}
	/**
	*通过查询条件删除
	*/
	public void deleteByParameter(TbEstateInfo t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getTitle())){
			parameter.addQuery("title", t.getTitle());
		}
		if(StringUtils.isNotBlank(t.getContent())){
			parameter.addQuery("content", t.getContent());
		}
		if(StringUtils.isNotBlank(t.getEstateId())){
			parameter.addQuery("estateId", t.getEstateId());
		}
		if(StringUtils.isNotBlank(t.getCreateTime())){
			parameter.addQuery("createTime", t.getCreateTime());
		}
		this.tbEstateInfoDao.delete(parameter);
	}
	/**
	*通过id删除
	*/
	public void deleteById(String id) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id",id);
		this.tbEstateInfoDao.delete(parameter);
	}
	
	/**
	*通过id修改
	*/
	public void update(TbEstateInfo t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id", t.getId());
		if(StringUtils.isNotBlank(t.getTitle())){
			parameter.addUpdate("title", t.getTitle());
		}
		if(StringUtils.isNotBlank(t.getContent())){
			parameter.addUpdate("content", t.getContent());
		}
		if(StringUtils.isNotBlank(t.getEstateId())){
			parameter.addUpdate("estateId", t.getEstateId());
		}
		if(StringUtils.isNotBlank(t.getCreateTime())){
			parameter.addUpdate("createTime", t.getCreateTime());
		}
		this.tbEstateInfoDao.update(parameter);
	}
	/**
	*通过id查询--详情
	*/
	public TbEstateInfo detail(String id) throws Exception{
		SqlParameter parameter = SqlParameter.getSqlParameter();
		if(StringUtils.isNotBlank(id)){
			parameter.addQuery("id", id);			
		}
		Collection<TbEstateInfo> result = this.tbEstateInfoDao.page(parameter);
		for (TbEstateInfo t : result) {
			return t;
		}
		return null;
	}
	/**
	*通过查询条件查询--分页
	*/
	public Map<String,Object> query(TbEstateInfo t,int pageNo,int pageSize) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getTitle())){
			parameter.addQuery("title", t.getTitle());
		}
		if(StringUtils.isNotBlank(t.getContent())){
			parameter.addQuery("content", t.getContent());
		}
		if(StringUtils.isNotBlank(t.getEstateId())){
			parameter.addQuery("estateId", t.getEstateId());
		}
		if(StringUtils.isNotBlank(t.getCreateTime())){
			parameter.addQuery("createTime", t.getCreateTime());
		}
		parameter.addPageNo((pageNo-1)*pageSize);
		parameter.addPageSize(pageSize);
		parameter.addOrder("ID", Order.Desc);//生成默认按照id倒序排
		Collection<TbEstateInfo> list=this.tbEstateInfoDao.page(parameter);
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
		return tbEstateInfoDao.totalCount(parameter);
	}
}