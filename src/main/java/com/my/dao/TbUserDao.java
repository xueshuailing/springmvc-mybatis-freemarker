package com.my.dao;
import java.util.Collection;

import javax.annotation.Resource;

import org.gitchina.framework.commons.dao.ReadDao;
import org.gitchina.framework.commons.dao.WriteDao;
import org.gitchina.framework.commons.dao.support.SqlParameter;
import org.springframework.stereotype.Repository;
import com.my.entity.TbUser;
/**
 * dao层
 */
@Repository
public class TbUserDao {
	@Resource
	private ReadDao readDao;
	@Resource
	private WriteDao writeDao;
	public long create(TbUser appointment) {
		return writeDao.create(TbUser.class, "TbUser_create", appointment);
	}
	
	public long totalCount(SqlParameter parameter) {
		return readDao.count(TbUser.class, "TbUser_count", parameter);
	}
	
	public Collection<TbUser> page(SqlParameter parameter) {
		return readDao.select(TbUser.class, "TbUser_page", parameter);
	}
	
	public TbUser read(SqlParameter parameter) {
		return readDao.read(TbUser.class, "TbUser_read", parameter);
	}
	
	public int delete(SqlParameter parameter) {
		return writeDao.delete(TbUser.class, "TbUser_delete", parameter);
	}
	
	public int update(SqlParameter parameter) {
		return writeDao.update(TbUser.class, "TbUser_update", parameter);
	}
 
}