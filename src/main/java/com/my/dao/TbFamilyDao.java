package com.my.dao;
import java.util.Collection;

import javax.annotation.Resource;

import org.gitchina.framework.commons.dao.ReadDao;
import org.gitchina.framework.commons.dao.WriteDao;
import org.gitchina.framework.commons.dao.support.SqlParameter;
import org.springframework.stereotype.Repository;
import com.my.entity.TbFamily;
/**
 * 家庭成员表dao层
 */
@Repository
public class TbFamilyDao {
	@Resource
	private ReadDao readDao;
	@Resource
	private WriteDao writeDao;
	public long create(TbFamily appointment) {
		return writeDao.create(TbFamily.class, "TbFamily_create", appointment);
	}
	
	public long totalCount(SqlParameter parameter) {
		return readDao.count(TbFamily.class, "TbFamily_count", parameter);
	}
	
	public Collection<TbFamily> page(SqlParameter parameter) {
		return readDao.select(TbFamily.class, "TbFamily_page", parameter);
	}
	
	public TbFamily read(SqlParameter parameter) {
		return readDao.read(TbFamily.class, "TbFamily_read", parameter);
	}
	
	public int delete(SqlParameter parameter) {
		return writeDao.delete(TbFamily.class, "TbFamily_delete", parameter);
	}
	
	public int update(SqlParameter parameter) {
		return writeDao.update(TbFamily.class, "TbFamily_update", parameter);
	}
 
}