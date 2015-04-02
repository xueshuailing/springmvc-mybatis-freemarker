package com.my.dao;
import java.util.Collection;

import javax.annotation.Resource;

import org.gitchina.framework.commons.dao.ReadDao;
import org.gitchina.framework.commons.dao.WriteDao;
import org.gitchina.framework.commons.dao.support.SqlParameter;
import org.springframework.stereotype.Repository;
import com.my.entity.OrderComment;
/**
 * dao层
 */
@Repository
public class OrderCommentDao {
	@Resource
	private ReadDao readDao;
	@Resource
	private WriteDao writeDao;
	public long create(OrderComment appointment) {
		return writeDao.create(OrderComment.class, "OrderComment_create", appointment);
	}
	
	public long totalCount(SqlParameter parameter) {
		return readDao.count(OrderComment.class, "OrderComment_count", parameter);
	}
	
	public Collection<OrderComment> page(SqlParameter parameter) {
		return readDao.select(OrderComment.class, "OrderComment_page", parameter);
	}
	
	public OrderComment read(SqlParameter parameter) {
		return readDao.read(OrderComment.class, "OrderComment_read", parameter);
	}
	
	public int delete(SqlParameter parameter) {
		return writeDao.delete(OrderComment.class, "OrderComment_delete", parameter);
	}
	
	public int update(SqlParameter parameter) {
		return writeDao.update(OrderComment.class, "OrderComment_update", parameter);
	}
 
}