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
import com.my.dao.TbAccountDao;
import com.my.entity.TbAccount;
/**
 * service层
 */
@Service
@Transactional
public class TbAccountService {
	@Resource
	private TbAccountDao tbAccountDao;
	/**
	*保存
	*/
	public void save(TbAccount t) throws Exception{
		this.tbAccountDao.create(t);
	}
	/**
	*通过查询条件删除
	*/
	public void deleteByParameter(TbAccount t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getUserId())){
			parameter.addQuery("userId", t.getUserId());
		}
		if(StringUtils.isNotBlank(t.getCreateDate())){
			parameter.addQuery("createDate", t.getCreateDate());
		}
		if(StringUtils.isNotBlank(t.getMoney())){
			parameter.addQuery("money", t.getMoney());
		}
		this.tbAccountDao.delete(parameter);
	}
	/**
	*通过id删除
	*/
	public void deleteById(String id) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id",id);
		this.tbAccountDao.delete(parameter);
	}
	
	/**
	*通过id修改
	*/
	public void update(TbAccount t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id", t.getId());
		if(StringUtils.isNotBlank(t.getUserId())){
			parameter.addUpdate("userId", t.getUserId());
		}
		if(StringUtils.isNotBlank(t.getCreateDate())){
			parameter.addUpdate("createDate", t.getCreateDate());
		}
		if(StringUtils.isNotBlank(t.getMoney())){
			parameter.addUpdate("money", t.getMoney());
		}
		this.tbAccountDao.update(parameter);
	}
	/**
	*通过id查询--详情
	*/
	public TbAccount detail(String id) throws Exception{
		SqlParameter parameter = SqlParameter.getSqlParameter();
		if(StringUtils.isNotBlank(id)){
			parameter.addQuery("id", id);			
		}
		Collection<TbAccount> result = this.tbAccountDao.page(parameter);
		for (TbAccount t : result) {
			return t;
		}
		return null;
	}
	/**
	*通过查询条件查询--分页
	*/
	public Map<String,Object> query(TbAccount t,int pageNo,int pageSize) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getUserId())){
			parameter.addQuery("userId", t.getUserId());
		}
		if(StringUtils.isNotBlank(t.getCreateDate())){
			parameter.addQuery("createDate", t.getCreateDate());
		}
		if(StringUtils.isNotBlank(t.getMoney())){
			parameter.addQuery("money", t.getMoney());
		}
		parameter.addPageNo((pageNo-1)*pageSize);
		parameter.addPageSize(pageSize);
		parameter.addOrder("ID", Order.Desc);//生成默认按照id倒序排
		Collection<TbAccount> list=this.tbAccountDao.page(parameter);
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
		return tbAccountDao.totalCount(parameter);
	}
}