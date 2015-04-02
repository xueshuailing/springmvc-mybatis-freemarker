package com.my.dao;
import java.util.Collection;

import javax.annotation.Resource;

import org.gitchina.framework.commons.dao.ReadDao;
import org.gitchina.framework.commons.dao.WriteDao;
import org.gitchina.framework.commons.dao.support.SqlParameter;
import org.springframework.stereotype.Repository;
import com.my.entity.TbShopping;
/**
 * dao层
 */
@Repository
public class TbShoppingDao {
	@Resource
	private ReadDao readDao;
	@Resource
	private WriteDao writeDao;
	public long create(TbShopping appointment) {
		return writeDao.create(TbShopping.class, "TbShopping_create", appointment);
	}
	
	public long totalCount(SqlParameter parameter) {
		return readDao.count(TbShopping.class, "TbShopping_count", parameter);
	}
	
	public Collection<TbShopping> page(SqlParameter parameter) {
		return readDao.select(TbShopping.class, "TbShopping_page", parameter);
	}
	
	public TbShopping read(SqlParameter parameter) {
		return readDao.read(TbShopping.class, "TbShopping_read", parameter);
	}
	
	public int delete(SqlParameter parameter) {
		return writeDao.delete(TbShopping.class, "TbShopping_delete", parameter);
	}
	
	public int update(SqlParameter parameter) {
		return writeDao.update(TbShopping.class, "TbShopping_update", parameter);
	}
 
}