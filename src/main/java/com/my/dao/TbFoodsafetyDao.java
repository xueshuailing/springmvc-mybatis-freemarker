package com.my.dao;
import java.util.Collection;

import javax.annotation.Resource;

import org.gitchina.framework.commons.dao.ReadDao;
import org.gitchina.framework.commons.dao.WriteDao;
import org.gitchina.framework.commons.dao.support.SqlParameter;
import org.springframework.stereotype.Repository;
import com.my.entity.TbFoodsafety;
/**
 * dao层
 */
@Repository
public class TbFoodsafetyDao {
	@Resource
	private ReadDao readDao;
	@Resource
	private WriteDao writeDao;
	public long create(TbFoodsafety appointment) {
		return writeDao.create(TbFoodsafety.class, "TbFoodsafety_create", appointment);
	}
	
	public long totalCount(SqlParameter parameter) {
		return readDao.count(TbFoodsafety.class, "TbFoodsafety_count", parameter);
	}
	
	public Collection<TbFoodsafety> page(SqlParameter parameter) {
		return readDao.select(TbFoodsafety.class, "TbFoodsafety_page", parameter);
	}
	
	public TbFoodsafety read(SqlParameter parameter) {
		return readDao.read(TbFoodsafety.class, "TbFoodsafety_read", parameter);
	}
	
	public int delete(SqlParameter parameter) {
		return writeDao.delete(TbFoodsafety.class, "TbFoodsafety_delete", parameter);
	}
	
	public int update(SqlParameter parameter) {
		return writeDao.update(TbFoodsafety.class, "TbFoodsafety_update", parameter);
	}
 
}