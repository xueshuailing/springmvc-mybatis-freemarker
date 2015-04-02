package com.my.dao;
import java.util.Collection;

import javax.annotation.Resource;

import org.gitchina.framework.commons.dao.ReadDao;
import org.gitchina.framework.commons.dao.WriteDao;
import org.gitchina.framework.commons.dao.support.SqlParameter;
import org.springframework.stereotype.Repository;
import com.my.entity.Province;
/**
 * dao层
 */
@Repository
public class ProvinceDao {
	@Resource
	private ReadDao readDao;
	@Resource
	private WriteDao writeDao;
	public long create(Province appointment) {
		return writeDao.create(Province.class, "Province_create", appointment);
	}
	
	public long totalCount(SqlParameter parameter) {
		return readDao.count(Province.class, "Province_count", parameter);
	}
	
	public Collection<Province> page(SqlParameter parameter) {
		return readDao.select(Province.class, "Province_page", parameter);
	}
	
	public Province read(SqlParameter parameter) {
		return readDao.read(Province.class, "Province_read", parameter);
	}
	
	public int delete(SqlParameter parameter) {
		return writeDao.delete(Province.class, "Province_delete", parameter);
	}
	
	public int update(SqlParameter parameter) {
		return writeDao.update(Province.class, "Province_update", parameter);
	}
 
}