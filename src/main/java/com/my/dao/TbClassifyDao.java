package com.my.dao;
import java.util.Collection;

import javax.annotation.Resource;

import org.gitchina.framework.commons.dao.ReadDao;
import org.gitchina.framework.commons.dao.WriteDao;
import org.gitchina.framework.commons.dao.support.SqlParameter;
import org.springframework.stereotype.Repository;
import com.my.entity.TbClassify;
/**
 * dao层
 */
@Repository
public class TbClassifyDao {
	@Resource
	private ReadDao readDao;
	@Resource
	private WriteDao writeDao;
	public long create(TbClassify appointment) {
		return writeDao.create(TbClassify.class, "TbClassify_create", appointment);
	}
	
	public long totalCount(SqlParameter parameter) {
		return readDao.count(TbClassify.class, "TbClassify_count", parameter);
	}
	
	public Collection<TbClassify> page(SqlParameter parameter) {
		return readDao.select(TbClassify.class, "TbClassify_page", parameter);
	}
	
	public TbClassify read(SqlParameter parameter) {
		return readDao.read(TbClassify.class, "TbClassify_read", parameter);
	}
	
	public int delete(SqlParameter parameter) {
		return writeDao.delete(TbClassify.class, "TbClassify_delete", parameter);
	}
	
	public int update(SqlParameter parameter) {
		return writeDao.update(TbClassify.class, "TbClassify_update", parameter);
	}
 
}