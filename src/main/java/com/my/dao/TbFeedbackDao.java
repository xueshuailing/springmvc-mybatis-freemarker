package com.my.dao;
import java.util.Collection;

import javax.annotation.Resource;

import org.gitchina.framework.commons.dao.ReadDao;
import org.gitchina.framework.commons.dao.WriteDao;
import org.gitchina.framework.commons.dao.support.SqlParameter;
import org.springframework.stereotype.Repository;
import com.my.entity.TbFeedback;
/**
 * dao层
 */
@Repository
public class TbFeedbackDao {
	@Resource
	private ReadDao readDao;
	@Resource
	private WriteDao writeDao;
	public long create(TbFeedback appointment) {
		return writeDao.create(TbFeedback.class, "TbFeedback_create", appointment);
	}
	
	public long totalCount(SqlParameter parameter) {
		return readDao.count(TbFeedback.class, "TbFeedback_count", parameter);
	}
	
	public Collection<TbFeedback> page(SqlParameter parameter) {
		return readDao.select(TbFeedback.class, "TbFeedback_page", parameter);
	}
	
	public TbFeedback read(SqlParameter parameter) {
		return readDao.read(TbFeedback.class, "TbFeedback_read", parameter);
	}
	
	public int delete(SqlParameter parameter) {
		return writeDao.delete(TbFeedback.class, "TbFeedback_delete", parameter);
	}
	
	public int update(SqlParameter parameter) {
		return writeDao.update(TbFeedback.class, "TbFeedback_update", parameter);
	}
 
}