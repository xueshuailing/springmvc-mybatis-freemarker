package com.my.dao;
import java.util.Collection;

import javax.annotation.Resource;

import org.gitchina.framework.commons.dao.ReadDao;
import org.gitchina.framework.commons.dao.WriteDao;
import org.gitchina.framework.commons.dao.support.SqlParameter;
import org.springframework.stereotype.Repository;
import com.my.entity.TbGoodsProperties;
/**
 * dao层
 */
@Repository
public class TbGoodsPropertiesDao {
	@Resource
	private ReadDao readDao;
	@Resource
	private WriteDao writeDao;
	public long create(TbGoodsProperties appointment) {
		return writeDao.create(TbGoodsProperties.class, "TbGoodsProperties_create", appointment);
	}
	
	public long totalCount(SqlParameter parameter) {
		return readDao.count(TbGoodsProperties.class, "TbGoodsProperties_count", parameter);
	}
	
	public Collection<TbGoodsProperties> page(SqlParameter parameter) {
		return readDao.select(TbGoodsProperties.class, "TbGoodsProperties_page", parameter);
	}
	
	public TbGoodsProperties read(SqlParameter parameter) {
		return readDao.read(TbGoodsProperties.class, "TbGoodsProperties_read", parameter);
	}
	
	public int delete(SqlParameter parameter) {
		return writeDao.delete(TbGoodsProperties.class, "TbGoodsProperties_delete", parameter);
	}
	
	public int update(SqlParameter parameter) {
		return writeDao.update(TbGoodsProperties.class, "TbGoodsProperties_update", parameter);
	}
 
}