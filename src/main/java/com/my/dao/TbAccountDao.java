package com.my.dao;
import java.util.Collection;

import javax.annotation.Resource;

import org.gitchina.framework.commons.dao.ReadDao;
import org.gitchina.framework.commons.dao.WriteDao;
import org.gitchina.framework.commons.dao.support.SqlParameter;
import org.springframework.stereotype.Repository;
import com.my.entity.TbAccount;
/**
 * dao层
 */
@Repository
public class TbAccountDao {
	@Resource
	private ReadDao readDao;
	@Resource
	private WriteDao writeDao;
	public long create(TbAccount appointment) {
		return writeDao.create(TbAccount.class, "TbAccount_create", appointment);
	}
	
	public long totalCount(SqlParameter parameter) {
		return readDao.count(TbAccount.class, "TbAccount_count", parameter);
	}
	
	public Collection<TbAccount> page(SqlParameter parameter) {
		return readDao.select(TbAccount.class, "TbAccount_page", parameter);
	}
	
	public TbAccount read(SqlParameter parameter) {
		return readDao.read(TbAccount.class, "TbAccount_read", parameter);
	}
	
	public int delete(SqlParameter parameter) {
		return writeDao.delete(TbAccount.class, "TbAccount_delete", parameter);
	}
	
	public int update(SqlParameter parameter) {
		return writeDao.update(TbAccount.class, "TbAccount_update", parameter);
	}
 
}