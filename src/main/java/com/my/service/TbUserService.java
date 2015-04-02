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
 * service层
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
		if(StringUtils.isNotBlank(t.getUserName())){
			parameter.addQuery("userName", t.getUserName());
		}
		if(StringUtils.isNotBlank(t.getUserPassword())){
			parameter.addQuery("userPassword", t.getUserPassword());
		}
		if(StringUtils.isNotBlank(t.getPosition())){
			parameter.addQuery("position", t.getPosition());
		}
		if(StringUtils.isNotBlank(t.getPhoneNumber())){
			parameter.addQuery("phoneNumber", t.getPhoneNumber());
		}
		if(StringUtils.isNotBlank(t.getEmail())){
			parameter.addQuery("email", t.getEmail());
		}
		if(StringUtils.isNotBlank(t.getSex())){
			parameter.addQuery("sex", t.getSex());
		}
		if(StringUtils.isNotBlank(t.getName())){
			parameter.addQuery("name", t.getName());
		}
		if(StringUtils.isNotBlank(t.getAge())){
			parameter.addQuery("age", t.getAge());
		}
		if(StringUtils.isNotBlank(t.getAddress())){
			parameter.addQuery("address", t.getAddress());
		}
		if(StringUtils.isNotBlank(t.getUserBigLogo())){
			parameter.addQuery("userBigLogo", t.getUserBigLogo());
		}
		if(StringUtils.isNotBlank(t.getUserSmallLogo())){
			parameter.addQuery("userSmallLogo", t.getUserSmallLogo());
		}
		if(StringUtils.isNotBlank(t.getJpushId())){
			parameter.addQuery("jpushId", t.getJpushId());
		}
		if(StringUtils.isNotBlank(t.getBalance())){
			parameter.addQuery("balance", t.getBalance());
		}
		if(StringUtils.isNotBlank(t.getCreateTime())){
			parameter.addQuery("createTime", t.getCreateTime());
		}
		if(StringUtils.isNotBlank(t.getType())){
			parameter.addQuery("type", t.getType());
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
		if(StringUtils.isNotBlank(t.getUserName())){
			parameter.addUpdate("userName", t.getUserName());
		}
		if(StringUtils.isNotBlank(t.getUserPassword())){
			parameter.addUpdate("userPassword", t.getUserPassword());
		}
		if(StringUtils.isNotBlank(t.getPosition())){
			parameter.addUpdate("position", t.getPosition());
		}
		if(StringUtils.isNotBlank(t.getPhoneNumber())){
			parameter.addUpdate("phoneNumber", t.getPhoneNumber());
		}
		if(StringUtils.isNotBlank(t.getEmail())){
			parameter.addUpdate("email", t.getEmail());
		}
		if(StringUtils.isNotBlank(t.getSex())){
			parameter.addUpdate("sex", t.getSex());
		}
		if(StringUtils.isNotBlank(t.getName())){
			parameter.addUpdate("name", t.getName());
		}
		if(StringUtils.isNotBlank(t.getAge())){
			parameter.addUpdate("age", t.getAge());
		}
		if(StringUtils.isNotBlank(t.getAddress())){
			parameter.addUpdate("address", t.getAddress());
		}
		if(StringUtils.isNotBlank(t.getUserBigLogo())){
			parameter.addUpdate("userBigLogo", t.getUserBigLogo());
		}
		if(StringUtils.isNotBlank(t.getUserSmallLogo())){
			parameter.addUpdate("userSmallLogo", t.getUserSmallLogo());
		}
		if(StringUtils.isNotBlank(t.getJpushId())){
			parameter.addUpdate("jpushId", t.getJpushId());
		}
		if(StringUtils.isNotBlank(t.getBalance())){
			parameter.addUpdate("balance", t.getBalance());
		}
		if(StringUtils.isNotBlank(t.getCreateTime())){
			parameter.addUpdate("createTime", t.getCreateTime());
		}
		if(StringUtils.isNotBlank(t.getType())){
			parameter.addUpdate("type", t.getType());
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
		if(StringUtils.isNotBlank(t.getUserName())){
			parameter.addQuery("userName", t.getUserName());
		}
		if(StringUtils.isNotBlank(t.getUserPassword())){
			parameter.addQuery("userPassword", t.getUserPassword());
		}
		if(StringUtils.isNotBlank(t.getPosition())){
			parameter.addQuery("position", t.getPosition());
		}
		if(StringUtils.isNotBlank(t.getPhoneNumber())){
			parameter.addQuery("phoneNumber", t.getPhoneNumber());
		}
		if(StringUtils.isNotBlank(t.getEmail())){
			parameter.addQuery("email", t.getEmail());
		}
		if(StringUtils.isNotBlank(t.getSex())){
			parameter.addQuery("sex", t.getSex());
		}
		if(StringUtils.isNotBlank(t.getName())){
			parameter.addQuery("name", t.getName());
		}
		if(StringUtils.isNotBlank(t.getAge())){
			parameter.addQuery("age", t.getAge());
		}
		if(StringUtils.isNotBlank(t.getAddress())){
			parameter.addQuery("address", t.getAddress());
		}
		if(StringUtils.isNotBlank(t.getUserBigLogo())){
			parameter.addQuery("userBigLogo", t.getUserBigLogo());
		}
		if(StringUtils.isNotBlank(t.getUserSmallLogo())){
			parameter.addQuery("userSmallLogo", t.getUserSmallLogo());
		}
		if(StringUtils.isNotBlank(t.getJpushId())){
			parameter.addQuery("jpushId", t.getJpushId());
		}
		if(StringUtils.isNotBlank(t.getBalance())){
			parameter.addQuery("balance", t.getBalance());
		}
		if(StringUtils.isNotBlank(t.getCreateTime())){
			parameter.addQuery("createTime", t.getCreateTime());
		}
		if(StringUtils.isNotBlank(t.getType())){
			parameter.addQuery("type", t.getType());
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