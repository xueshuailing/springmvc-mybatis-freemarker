package com.my.dao;
import java.util.Collection;

import javax.annotation.Resource;

import org.gitchina.framework.commons.dao.ReadDao;
import org.gitchina.framework.commons.dao.WriteDao;
import org.gitchina.framework.commons.dao.support.SqlParameter;
import org.springframework.stereotype.Repository;
import com.my.entity.TbType;
/**
 * 收入、支出类型字典表dao层
 */
@Repository
public class TbTypeDao {
	@Resource
	private ReadDao readDao;
	@Resource
	private WriteDao writeDao;
	public long create(TbType appointment) {
		return writeDao.create(TbType.class, "TbType_create", appointment);
	}
	
	public long totalCount(SqlParameter parameter) {
		return readDao.count(TbType.class, "TbType_count", parameter);
	}
	
	public Collection<TbType> page(SqlParameter parameter) {
		return readDao.select(TbType.class, "TbType_page", parameter);
	}
	
	public TbType read(SqlParameter parameter) {
		return readDao.read(TbType.class, "TbType_read", parameter);
	}
	
	public int delete(SqlParameter parameter) {
		return writeDao.delete(TbType.class, "TbType_delete", parameter);
	}
	
	public int update(SqlParameter parameter) {
		return writeDao.update(TbType.class, "TbType_update", parameter);
	}
 
}