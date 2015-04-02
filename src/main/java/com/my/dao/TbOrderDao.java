package com.my.dao;
import java.util.Collection;

import javax.annotation.Resource;

import org.gitchina.framework.commons.dao.ReadDao;
import org.gitchina.framework.commons.dao.WriteDao;
import org.gitchina.framework.commons.dao.support.SqlParameter;
import org.springframework.stereotype.Repository;
import com.my.entity.TbOrder;
/**
 * dao层
 */
@Repository
public class TbOrderDao {
	@Resource
	private ReadDao readDao;
	@Resource
	private WriteDao writeDao;
	public long create(TbOrder appointment) {
		return writeDao.create(TbOrder.class, "TbOrder_create", appointment);
	}
	
	public long totalCount(SqlParameter parameter) {
		return readDao.count(TbOrder.class, "TbOrder_count", parameter);
	}
	
	public Collection<TbOrder> page(SqlParameter parameter) {
		return readDao.select(TbOrder.class, "TbOrder_page", parameter);
	}
	
	public TbOrder read(SqlParameter parameter) {
		return readDao.read(TbOrder.class, "TbOrder_read", parameter);
	}
	
	public int delete(SqlParameter parameter) {
		return writeDao.delete(TbOrder.class, "TbOrder_delete", parameter);
	}
	
	public int update(SqlParameter parameter) {
		return writeDao.update(TbOrder.class, "TbOrder_update", parameter);
	}
 
}