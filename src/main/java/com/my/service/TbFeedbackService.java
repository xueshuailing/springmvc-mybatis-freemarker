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
import com.my.dao.TbFeedbackDao;
import com.my.entity.TbFeedback;
/**
 * service层
 */
@Service
@Transactional
public class TbFeedbackService {
	@Resource
	private TbFeedbackDao tbFeedbackDao;
	/**
	*保存
	*/
	public void save(TbFeedback t) throws Exception{
		this.tbFeedbackDao.create(t);
	}
	/**
	*通过查询条件删除
	*/
	public void deleteByParameter(TbFeedback t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getPhone())){
			parameter.addQuery("phone", t.getPhone());
		}
		if(StringUtils.isNotBlank(t.getOpinion())){
			parameter.addQuery("opinion", t.getOpinion());
		}
		if(StringUtils.isNotBlank(t.getUserId())){
			parameter.addQuery("userId", t.getUserId());
		}
		if(StringUtils.isNotBlank(t.getDateTime())){
			parameter.addQuery("dateTime", t.getDateTime());
		}
		if(StringUtils.isNotBlank(t.getUserName())){
			parameter.addQuery("userName", t.getUserName());
		}
		this.tbFeedbackDao.delete(parameter);
	}
	/**
	*通过id删除
	*/
	public void deleteById(String id) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id",id);
		this.tbFeedbackDao.delete(parameter);
	}
	
	/**
	*通过id修改
	*/
	public void update(TbFeedback t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id", t.getId());
		if(StringUtils.isNotBlank(t.getPhone())){
			parameter.addUpdate("phone", t.getPhone());
		}
		if(StringUtils.isNotBlank(t.getOpinion())){
			parameter.addUpdate("opinion", t.getOpinion());
		}
		if(StringUtils.isNotBlank(t.getUserId())){
			parameter.addUpdate("userId", t.getUserId());
		}
		if(StringUtils.isNotBlank(t.getDateTime())){
			parameter.addUpdate("dateTime", t.getDateTime());
		}
		if(StringUtils.isNotBlank(t.getUserName())){
			parameter.addUpdate("userName", t.getUserName());
		}
		this.tbFeedbackDao.update(parameter);
	}
	/**
	*通过id查询--详情
	*/
	public TbFeedback detail(String id) throws Exception{
		SqlParameter parameter = SqlParameter.getSqlParameter();
		if(StringUtils.isNotBlank(id)){
			parameter.addQuery("id", id);			
		}
		Collection<TbFeedback> result = this.tbFeedbackDao.page(parameter);
		for (TbFeedback t : result) {
			return t;
		}
		return null;
	}
	/**
	*通过查询条件查询--分页
	*/
	public Map<String,Object> query(TbFeedback t,int pageNo,int pageSize) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getPhone())){
			parameter.addQuery("phone", t.getPhone());
		}
		if(StringUtils.isNotBlank(t.getOpinion())){
			parameter.addQuery("opinion", t.getOpinion());
		}
		if(StringUtils.isNotBlank(t.getUserId())){
			parameter.addQuery("userId", t.getUserId());
		}
		if(StringUtils.isNotBlank(t.getDateTime())){
			parameter.addQuery("dateTime", t.getDateTime());
		}
		if(StringUtils.isNotBlank(t.getUserName())){
			parameter.addQuery("userName", t.getUserName());
		}
		parameter.addPageNo((pageNo-1)*pageSize);
		parameter.addPageSize(pageSize);
		parameter.addOrder("ID", Order.Desc);//生成默认按照id倒序排
		Collection<TbFeedback> list=this.tbFeedbackDao.page(parameter);
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
		return tbFeedbackDao.totalCount(parameter);
	}
}