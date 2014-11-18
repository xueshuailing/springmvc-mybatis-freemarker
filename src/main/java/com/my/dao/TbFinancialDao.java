package com.my.dao;
import java.util.Collection;

import javax.annotation.Resource;

import org.gitchina.framework.commons.dao.ReadDao;
import org.gitchina.framework.commons.dao.WriteDao;
import org.gitchina.framework.commons.dao.support.SqlParameter;
import org.springframework.stereotype.Repository;
import com.my.entity.TbFinancial;
/**
 * 家庭收入、支出表dao层
 */
@Repository
public class TbFinancialDao {
	@Resource
	private ReadDao readDao;
	@Resource
	private WriteDao writeDao;
	public long create(TbFinancial appointment) {
		return writeDao.create(TbFinancial.class, "TbFinancial_create", appointment);
	}
	
	public long totalCount(SqlParameter parameter) {
		return readDao.count(TbFinancial.class, "TbFinancial_count", parameter);
	}
	
	public Collection<TbFinancial> page(SqlParameter parameter) {
		return readDao.select(TbFinancial.class, "TbFinancial_page", parameter);
	}
	
	public TbFinancial read(SqlParameter parameter) {
		return readDao.read(TbFinancial.class, "TbFinancial_read", parameter);
	}
	
	public int delete(SqlParameter parameter) {
		return writeDao.delete(TbFinancial.class, "TbFinancial_delete", parameter);
	}
	
	public int update(SqlParameter parameter) {
		return writeDao.update(TbFinancial.class, "TbFinancial_update", parameter);
	}
 
}