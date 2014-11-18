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
import com.my.dao.TbUserDao;
import com.my.entity.TbUser;
/**
 * 用户注册表（家庭成员管理员表）service层
 */
@Service
@Transactional
public class TbUserService {
	@Resource
	private TbUserDao tbUserDao;
	/**
	*保存
	*/
	public void save(TbUser t) throws Exception{
		this.tbUserDao.create(t);
	}
	/**
	*通过查询条件删除
	*/
	public void deleteByParameter(TbUser t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getName())){
			parameter.addQuery("name", t.getName());
		}
		if(StringUtils.isNotBlank(t.getAge())){
			parameter.addQuery("age", t.getAge());
		}
		if(StringUtils.isNotBlank(t.getSex())){
			parameter.addQuery("sex", t.getSex());
		}
		if(StringUtils.isNotBlank(t.getEmail())){
			parameter.addQuery("email", t.getEmail());
		}
		if(StringUtils.isNotBlank(t.getPhone())){
			parameter.addQuery("phone", t.getPhone());
		}
		if(StringUtils.isNotBlank(t.getPassword())){
			parameter.addQuery("password", t.getPassword());
		}
		if(StringUtils.isNotBlank(t.getTime())){
			parameter.addQuery("time", t.getTime());
		}
		if(StringUtils.isNotBlank(t.getState())){
			parameter.addQuery("state", t.getState());
		}
		if(StringUtils.isNotBlank(t.getNumber())){
			parameter.addQuery("number", t.getNumber());
		}
		if(StringUtils.isNotBlank(t.getEndTime())){
			parameter.addQuery("endTime", t.getEndTime());
		}
		this.tbUserDao.delete(parameter);
	}
	/**
	*通过id删除
	*/
	public void deleteById(String id) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id",id);
		this.tbUserDao.delete(parameter);
	}
	
	/**
	*通过id修改
	*/
	public void update(TbUser t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id", t.getId());
		if(StringUtils.isNotBlank(t.getName())){
			parameter.addUpdate("name", t.getName());
		}
		if(StringUtils.isNotBlank(t.getAge())){
			parameter.addUpdate("age", t.getAge());
		}
		if(StringUtils.isNotBlank(t.getSex())){
			parameter.addUpdate("sex", t.getSex());
		}
		if(StringUtils.isNotBlank(t.getEmail())){
			parameter.addUpdate("email", t.getEmail());
		}
		if(StringUtils.isNotBlank(t.getPhone())){
			parameter.addUpdate("phone", t.getPhone());
		}
		if(StringUtils.isNotBlank(t.getPassword())){
			parameter.addUpdate("password", t.getPassword());
		}
		if(StringUtils.isNotBlank(t.getTime())){
			parameter.addUpdate("time", t.getTime());
		}
		if(StringUtils.isNotBlank(t.getState())){
			parameter.addUpdate("state", t.getState());
		}
		if(StringUtils.isNotBlank(t.getNumber())){
			parameter.addUpdate("number", t.getNumber());
		}
		if(StringUtils.isNotBlank(t.getEndTime())){
			parameter.addUpdate("endTime", t.getEndTime());
		}
		this.tbUserDao.update(parameter);
	}
	/**
	*通过id查询--详情
	*/
	public TbUser detail(String id) throws Exception{
		SqlParameter parameter = SqlParameter.getSqlParameter();
		if(StringUtils.isNotBlank(id)){
			parameter.addQuery("id", id);			
		}
		Collection<TbUser> result = this.tbUserDao.page(parameter);
		for (TbUser t : result) {
			return t;
		}
		return null;
	}
	/**
	*通过查询条件查询--分页
	*/
	public Map<String,Object> query(TbUser t,int pageNo,int pageSize) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getName())){
			parameter.addQuery("name", t.getName());
		}
		if(StringUtils.isNotBlank(t.getAge())){
			parameter.addQuery("age", t.getAge());
		}
		if(StringUtils.isNotBlank(t.getSex())){
			parameter.addQuery("sex", t.getSex());
		}
		if(StringUtils.isNotBlank(t.getEmail())){
			parameter.addQuery("email", t.getEmail());
		}
		if(StringUtils.isNotBlank(t.getPhone())){
			parameter.addQuery("phone", t.getPhone());
		}
		if(StringUtils.isNotBlank(t.getPassword())){
			parameter.addQuery("password", t.getPassword());
		}
		if(StringUtils.isNotBlank(t.getTime())){
			parameter.addQuery("time", t.getTime());
		}
		if(StringUtils.isNotBlank(t.getState())){
			parameter.addQuery("state", t.getState());
		}
		if(StringUtils.isNotBlank(t.getNumber())){
			parameter.addQuery("number", t.getNumber());
		}
		if(StringUtils.isNotBlank(t.getEndTime())){
			parameter.addQuery("endTime", t.getEndTime());
		}
		parameter.addPageNo((pageNo-1)*pageSize);
		parameter.addPageSize(pageSize);
		parameter.addOrder("ID", Order.Desc);//生成默认按照id倒序排
		Collection<TbUser> list=this.tbUserDao.page(parameter);
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
		return tbUserDao.totalCount(parameter);
	}
}