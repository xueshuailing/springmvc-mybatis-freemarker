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
import com.my.dao.CountDao;
import com.my.entity.Count;
/**
 * service层
 */
@Service
@Transactional
public class CountService {
	@Resource
	private CountDao countDao;
	/**
	*保存
	*/
	public void save(Count t) throws Exception{
		this.countDao.create(t);
	}
	/**
	*通过查询条件删除
	*/
	public void deleteByParameter(Count t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getCountName())){
			parameter.addQuery("countName", t.getCountName());
		}
		if(StringUtils.isNotBlank(t.getCityId())){
			parameter.addQuery("cityId", t.getCityId());
		}
		if(StringUtils.isNotBlank(t.getCountSort())){
			parameter.addQuery("countSort", t.getCountSort());
		}
		this.countDao.delete(parameter);
	}
	/**
	*通过id删除
	*/
	public void deleteById(String id) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id",id);
		this.countDao.delete(parameter);
	}
	
	/**
	*通过id修改
	*/
	public void update(Count t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id", t.getId());
		if(StringUtils.isNotBlank(t.getCountName())){
			parameter.addUpdate("countName", t.getCountName());
		}
		if(StringUtils.isNotBlank(t.getCityId())){
			parameter.addUpdate("cityId", t.getCityId());
		}
		if(StringUtils.isNotBlank(t.getCountSort())){
			parameter.addUpdate("countSort", t.getCountSort());
		}
		this.countDao.update(parameter);
	}
	/**
	*通过id查询--详情
	*/
	public Count detail(String id) throws Exception{
		SqlParameter parameter = SqlParameter.getSqlParameter();
		if(StringUtils.isNotBlank(id)){
			parameter.addQuery("id", id);			
		}
		Collection<Count> result = this.countDao.page(parameter);
		for (Count t : result) {
			return t;
		}
		return null;
	}
	/**
	*通过查询条件查询--分页
	*/
	public Map<String,Object> query(Count t,int pageNo,int pageSize) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getCountName())){
			parameter.addQuery("countName", t.getCountName());
		}
		if(StringUtils.isNotBlank(t.getCityId())){
			parameter.addQuery("cityId", t.getCityId());
		}
		if(StringUtils.isNotBlank(t.getCountSort())){
			parameter.addQuery("countSort", t.getCountSort());
		}
		parameter.addPageNo((pageNo-1)*pageSize);
		parameter.addPageSize(pageSize);
		parameter.addOrder("ID", Order.Desc);//生成默认按照id倒序排
		Collection<Count> list=this.countDao.page(parameter);
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
		return countDao.totalCount(parameter);
	}
}