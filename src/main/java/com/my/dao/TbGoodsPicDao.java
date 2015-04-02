package com.my.dao;
import java.util.Collection;

import javax.annotation.Resource;

import org.gitchina.framework.commons.dao.ReadDao;
import org.gitchina.framework.commons.dao.WriteDao;
import org.gitchina.framework.commons.dao.support.SqlParameter;
import org.springframework.stereotype.Repository;
import com.my.entity.TbGoodsPic;
/**
 * dao层
 */
@Repository
public class TbGoodsPicDao {
	@Resource
	private ReadDao readDao;
	@Resource
	private WriteDao writeDao;
	public long create(TbGoodsPic appointment) {
		return writeDao.create(TbGoodsPic.class, "TbGoodsPic_create", appointment);
	}
	
	public long totalCount(SqlParameter parameter) {
		return readDao.count(TbGoodsPic.class, "TbGoodsPic_count", parameter);
	}
	
	public Collection<TbGoodsPic> page(SqlParameter parameter) {
		return readDao.select(TbGoodsPic.class, "TbGoodsPic_page", parameter);
	}
	
	public TbGoodsPic read(SqlParameter parameter) {
		return readDao.read(TbGoodsPic.class, "TbGoodsPic_read", parameter);
	}
	
	public int delete(SqlParameter parameter) {
		return writeDao.delete(TbGoodsPic.class, "TbGoodsPic_delete", parameter);
	}
	
	public int update(SqlParameter parameter) {
		return writeDao.update(TbGoodsPic.class, "TbGoodsPic_update", parameter);
	}
 
}