package com.my.dao;
import java.util.Collection;

import javax.annotation.Resource;

import org.gitchina.framework.commons.dao.ReadDao;
import org.gitchina.framework.commons.dao.WriteDao;
import org.gitchina.framework.commons.dao.support.SqlParameter;
import org.springframework.stereotype.Repository;
import com.my.entity.TbEstate;
/**
 * dao层
 */
@Repository
public class TbEstateDao {
	@Resource
	private ReadDao readDao;
	@Resource
	private WriteDao writeDao;
	public long create(TbEstate appointment) {
		return writeDao.create(TbEstate.class, "TbEstate_create", appointment);
	}
	
	public long totalCount(SqlParameter parameter) {
		return readDao.count(TbEstate.class, "TbEstate_count", parameter);
	}
	
	public Collection<TbEstate> page(SqlParameter parameter) {
		return readDao.select(TbEstate.class, "TbEstate_page", parameter);
	}
	
	public TbEstate read(SqlParameter parameter) {
		return readDao.read(TbEstate.class, "TbEstate_read", parameter);
	}
	
	public int delete(SqlParameter parameter) {
		return writeDao.delete(TbEstate.class, "TbEstate_delete", parameter);
	}
	
	public int update(SqlParameter parameter) {
		return writeDao.update(TbEstate.class, "TbEstate_update", parameter);
	}
 
}