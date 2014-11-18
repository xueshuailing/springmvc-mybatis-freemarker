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
import com.my.dao.TbFamilyDao;
import com.my.entity.TbFamily;
/**
 * 家庭成员表service层
 */
@Service
@Transactional
public class TbFamilyService {
	@Resource
	private TbFamilyDao tbFamilyDao;
	/**
	*保存
	*/
	public void save(TbFamily t) throws Exception{
		this.tbFamilyDao.create(t);
	}
	/**
	*通过查询条件删除
	*/
	public void deleteByParameter(TbFamily t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getName())){
			parameter.addQuery("name", t.getName());
		}
		if(StringUtils.isNotBlank(t.getSex())){
			parameter.addQuery("sex", t.getSex());
		}
		if(StringUtils.isNotBlank(t.getUserId())){
			parameter.addQuery("userId", t.getUserId());
		}
		if(StringUtils.isNotBlank(t.getCreateDate())){
			parameter.addQuery("createDate", t.getCreateDate());
		}
		if(StringUtils.isNotBlank(t.getAge())){
			parameter.addQuery("age", t.getAge());
		}
		this.tbFamilyDao.delete(parameter);
	}
	/**
	*通过id删除
	*/
	public void deleteById(String id) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id",id);
		this.tbFamilyDao.delete(parameter);
	}
	
	/**
	*通过id修改
	*/
	public void update(TbFamily t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id", t.getId());
		if(StringUtils.isNotBlank(t.getName())){
			parameter.addUpdate("name", t.getName());
		}
		if(StringUtils.isNotBlank(t.getSex())){
			parameter.addUpdate("sex", t.getSex());
		}
		if(StringUtils.isNotBlank(t.getUserId())){
			parameter.addUpdate("userId", t.getUserId());
		}
		if(StringUtils.isNotBlank(t.getCreateDate())){
			parameter.addUpdate("createDate", t.getCreateDate());
		}
		if(StringUtils.isNotBlank(t.getAge())){
			parameter.addUpdate("age", t.getAge());
		}
		this.tbFamilyDao.update(parameter);
	}
	/**
	*通过id查询--详情
	*/
	public TbFamily detail(String id) throws Exception{
		SqlParameter parameter = SqlParameter.getSqlParameter();
		if(StringUtils.isNotBlank(id)){
			parameter.addQuery("id", id);			
		}
		Collection<TbFamily> result = this.tbFamilyDao.page(parameter);
		for (TbFamily t : result) {
			return t;
		}
		return null;
	}
	/**
	*通过查询条件查询--分页
	*/
	public Map<String,Object> query(TbFamily t,int pageNo,int pageSize) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getName())){
			parameter.addQuery("name", t.getName());
		}
		if(StringUtils.isNotBlank(t.getSex())){
			parameter.addQuery("sex", t.getSex());
		}
		if(StringUtils.isNotBlank(t.getUserId())){
			parameter.addQuery("userId", t.getUserId());
		}
		if(StringUtils.isNotBlank(t.getCreateDate())){
			parameter.addQuery("createDate", t.getCreateDate());
		}
		if(StringUtils.isNotBlank(t.getAge())){
			parameter.addQuery("age", t.getAge());
		}
		parameter.addPageNo((pageNo-1)*pageSize);
		parameter.addPageSize(pageSize);
		parameter.addOrder("ID", Order.Desc);//生成默认按照id倒序排
		Collection<TbFamily> list=this.tbFamilyDao.page(parameter);
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
		return tbFamilyDao.totalCount(parameter);
	}
}