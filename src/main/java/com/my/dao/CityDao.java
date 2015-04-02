package com.my.dao;
import java.util.Collection;

import javax.annotation.Resource;

import org.gitchina.framework.commons.dao.ReadDao;
import org.gitchina.framework.commons.dao.WriteDao;
import org.gitchina.framework.commons.dao.support.SqlParameter;
import org.springframework.stereotype.Repository;
import com.my.entity.City;
/**
 * dao层
 */
@Repository
public class CityDao {
	@Resource
	private ReadDao readDao;
	@Resource
	private WriteDao writeDao;
	public long create(City appointment) {
		return writeDao.create(City.class, "City_create", appointment);
	}
	
	public long totalCount(SqlParameter parameter) {
		return readDao.count(City.class, "City_count", parameter);
	}
	
	public Collection<City> page(SqlParameter parameter) {
		return readDao.select(City.class, "City_page", parameter);
	}
	
	public City read(SqlParameter parameter) {
		return readDao.read(City.class, "City_read", parameter);
	}
	
	public int delete(SqlParameter parameter) {
		return writeDao.delete(City.class, "City_delete", parameter);
	}
	
	public int update(SqlParameter parameter) {
		return writeDao.update(City.class, "City_update", parameter);
	}
 
}