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
import com.my.dao.ProvinceDao;
import com.my.entity.Province;
/**
 * service层
 */
@Service
@Transactional
public class ProvinceService {
	@Resource
	private ProvinceDao provinceDao;
	/**
	*保存
	*/
	public void save(Province t) throws Exception{
		this.provinceDao.create(t);
	}
	/**
	*通过查询条件删除
	*/
	public void deleteByParameter(Province t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getProId())){
			parameter.addQuery("proId", t.getProId());
		}
		if(StringUtils.isNotBlank(t.getProName())){
			parameter.addQuery("proName", t.getProName());
		}
		if(StringUtils.isNotBlank(t.getProSort())){
			parameter.addQuery("proSort", t.getProSort());
		}
		if(StringUtils.isNotBlank(t.getProRemark())){
			parameter.addQuery("proRemark", t.getProRemark());
		}
		this.provinceDao.delete(parameter);
	}
	/**
	*通过id删除
	*/
	public void deleteById(String id) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id",id);
		this.provinceDao.delete(parameter);
	}
	
	/**
	*通过id修改
	*/
	public void update(Province t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id", t.getId());
		if(StringUtils.isNotBlank(t.getProId())){
			parameter.addUpdate("proId", t.getProId());
		}
		if(StringUtils.isNotBlank(t.getProName())){
			parameter.addUpdate("proName", t.getProName());
		}
		if(StringUtils.isNotBlank(t.getProSort())){
			parameter.addUpdate("proSort", t.getProSort());
		}
		if(StringUtils.isNotBlank(t.getProRemark())){
			parameter.addUpdate("proRemark", t.getProRemark());
		}
		this.provinceDao.update(parameter);
	}
	/**
	*通过id查询--详情
	*/
	public Province detail(String id) throws Exception{
		SqlParameter parameter = SqlParameter.getSqlParameter();
		if(StringUtils.isNotBlank(id)){
			parameter.addQuery("id", id);			
		}
		Collection<Province> result = this.provinceDao.page(parameter);
		for (Province t : result) {
			return t;
		}
		return null;
	}
	/**
	*通过查询条件查询--分页
	*/
	public Map<String,Object> query(Province t,int pageNo,int pageSize) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getProId())){
			parameter.addQuery("proId", t.getProId());
		}
		if(StringUtils.isNotBlank(t.getProName())){
			parameter.addQuery("proName", t.getProName());
		}
		if(StringUtils.isNotBlank(t.getProSort())){
			parameter.addQuery("proSort", t.getProSort());
		}
		if(StringUtils.isNotBlank(t.getProRemark())){
			parameter.addQuery("proRemark", t.getProRemark());
		}
		parameter.addPageNo((pageNo-1)*pageSize);
		parameter.addPageSize(pageSize);
		parameter.addOrder("ID", Order.Desc);//生成默认按照id倒序排
		Collection<Province> list=this.provinceDao.page(parameter);
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
		return provinceDao.totalCount(parameter);
	}
}