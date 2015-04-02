package com.my.dao;
import java.util.Collection;

import javax.annotation.Resource;

import org.gitchina.framework.commons.dao.ReadDao;
import org.gitchina.framework.commons.dao.WriteDao;
import org.gitchina.framework.commons.dao.support.SqlParameter;
import org.springframework.stereotype.Repository;
import com.my.entity.Count;
/**
 * dao层
 */
@Repository
public class CountDao {
	@Resource
	private ReadDao readDao;
	@Resource
	private WriteDao writeDao;
	public long create(Count appointment) {
		return writeDao.create(Count.class, "Count_create", appointment);
	}
	
	public long totalCount(SqlParameter parameter) {
		return readDao.count(Count.class, "Count_count", parameter);
	}
	
	public Collection<Count> page(SqlParameter parameter) {
		return readDao.select(Count.class, "Count_page", parameter);
	}
	
	public Count read(SqlParameter parameter) {
		return readDao.read(Count.class, "Count_read", parameter);
	}
	
	public int delete(SqlParameter parameter) {
		return writeDao.delete(Count.class, "Count_delete", parameter);
	}
	
	public int update(SqlParameter parameter) {
		return writeDao.update(Count.class, "Count_update", parameter);
	}
 
}