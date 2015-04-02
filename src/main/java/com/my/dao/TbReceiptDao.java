package com.my.dao;
import java.util.Collection;

import javax.annotation.Resource;

import org.gitchina.framework.commons.dao.ReadDao;
import org.gitchina.framework.commons.dao.WriteDao;
import org.gitchina.framework.commons.dao.support.SqlParameter;
import org.springframework.stereotype.Repository;
import com.my.entity.TbReceipt;
/**
 * 用户收货地址表dao层
 */
@Repository
public class TbReceiptDao {
	@Resource
	private ReadDao readDao;
	@Resource
	private WriteDao writeDao;
	public long create(TbReceipt appointment) {
		return writeDao.create(TbReceipt.class, "TbReceipt_create", appointment);
	}
	
	public long totalCount(SqlParameter parameter) {
		return readDao.count(TbReceipt.class, "TbReceipt_count", parameter);
	}
	
	public Collection<TbReceipt> page(SqlParameter parameter) {
		return readDao.select(TbReceipt.class, "TbReceipt_page", parameter);
	}
	
	public TbReceipt read(SqlParameter parameter) {
		return readDao.read(TbReceipt.class, "TbReceipt_read", parameter);
	}
	
	public int delete(SqlParameter parameter) {
		return writeDao.delete(TbReceipt.class, "TbReceipt_delete", parameter);
	}
	
	public int update(SqlParameter parameter) {
		return writeDao.update(TbReceipt.class, "TbReceipt_update", parameter);
	}
 
}