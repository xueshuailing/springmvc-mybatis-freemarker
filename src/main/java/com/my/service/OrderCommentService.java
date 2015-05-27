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
import com.my.dao.OrderCommentDao;
import com.my.entity.OrderComment;
/**
 * service层
 */
@Service
@Transactional
public class OrderCommentService {
	@Resource
	private OrderCommentDao orderCommentDao;
	/**
	*保存
	*/
	public void save(OrderComment t) throws Exception{
		this.orderCommentDao.create(t);
	}
	/**
	*通过查询条件删除
	*/
	public void deleteByParameter(OrderComment t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getUserId())){
			parameter.addQuery("userId", t.getUserId());
		}
		if(StringUtils.isNotBlank(t.getCommentTime())){
			parameter.addQuery("commentTime", t.getCommentTime());
		}
		if(StringUtils.isNotBlank(t.getCommentCotent())){
			parameter.addQuery("commentCotent", t.getCommentCotent());
		}
		if(StringUtils.isNotBlank(t.getIsShow())){
			parameter.addQuery("isShow", t.getIsShow());
		}
		if(StringUtils.isNotBlank(t.getIndentId())){
			parameter.addQuery("indentId", t.getIndentId());
		}
		if(StringUtils.isNotBlank(t.getName())){
			parameter.addQuery("name", t.getName());
		}
		if(StringUtils.isNotBlank(t.getScore())){
			parameter.addQuery("score", t.getScore());
		}
		this.orderCommentDao.delete(parameter);
	}
	/**
	*通过id删除
	*/
	public void deleteById(String id) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id",id);
		this.orderCommentDao.delete(parameter);
	}
	
	/**
	*通过id修改
	*/
	public void update(OrderComment t) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		parameter.addQuery("id", t.getId());
		if(StringUtils.isNotBlank(t.getUserId())){
			parameter.addUpdate("userId", t.getUserId());
		}
		if(StringUtils.isNotBlank(t.getCommentTime())){
			parameter.addUpdate("commentTime", t.getCommentTime());
		}
		if(StringUtils.isNotBlank(t.getCommentCotent())){
			parameter.addUpdate("commentCotent", t.getCommentCotent());
		}
		if(StringUtils.isNotBlank(t.getIsShow())){
			parameter.addUpdate("isShow", t.getIsShow());
		}
		if(StringUtils.isNotBlank(t.getIndentId())){
			parameter.addUpdate("indentId", t.getIndentId());
		}
		if(StringUtils.isNotBlank(t.getName())){
			parameter.addUpdate("name", t.getName());
		}
		if(StringUtils.isNotBlank(t.getScore())){
			parameter.addUpdate("score", t.getScore());
		}
		this.orderCommentDao.update(parameter);
	}
	/**
	*通过id查询--详情
	*/
	public OrderComment detail(String id) throws Exception{
		SqlParameter parameter = SqlParameter.getSqlParameter();
		if(StringUtils.isNotBlank(id)){
			parameter.addQuery("id", id);			
		}
		Collection<OrderComment> result = this.orderCommentDao.page(parameter);
		for (OrderComment t : result) {
			return t;
		}
		return null;
	}
	/**
	*通过查询条件查询--分页
	*/
	public Map<String,Object> query(OrderComment t,int pageNo,int pageSize) throws Exception{
		SqlParameter parameter=SqlParameter.getSqlParameter();
		if(t.getId()!=0){
			parameter.addQuery("id", t.getId());
		}
		if(StringUtils.isNotBlank(t.getUserId())){
			parameter.addQuery("userId", t.getUserId());
		}
		if(StringUtils.isNotBlank(t.getCommentTime())){
			parameter.addQuery("commentTime", t.getCommentTime());
		}
		if(StringUtils.isNotBlank(t.getCommentCotent())){
			parameter.addQuery("commentCotent", t.getCommentCotent());
		}
		if(StringUtils.isNotBlank(t.getIsShow())){
			parameter.addQuery("isShow", t.getIsShow());
		}
		if(StringUtils.isNotBlank(t.getIndentId())){
			parameter.addQuery("indentId", t.getIndentId());
		}
		if(StringUtils.isNotBlank(t.getName())){
			parameter.addQuery("name", t.getName());
		}
		if(StringUtils.isNotBlank(t.getScore())){
			parameter.addQuery("score", t.getScore());
		}
		parameter.addPageNo((pageNo-1)*pageSize);
		parameter.addPageSize(pageSize);
		parameter.addOrder("ID", Order.Desc);//生成默认按照id倒序排
		Collection<OrderComment> list=this.orderCommentDao.page(parameter);
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
		return orderCommentDao.totalCount(parameter);
	}
}