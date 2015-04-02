package com.my.dao;
import java.util.Collection;

import javax.annotation.Resource;

import org.gitchina.framework.commons.dao.ReadDao;
import org.gitchina.framework.commons.dao.WriteDao;
import org.gitchina.framework.commons.dao.support.SqlParameter;
import org.springframework.stereotype.Repository;
import com.my.entity.TbGoodsPropertiesGp;
/**
 * dao层
 */
@Repository
public class TbGoodsPropertiesGpDao {
	@Resource
	private ReadDao readDao;
	@Resource
	private WriteDao writeDao;
	public long create(TbGoodsPropertiesGp appointment) {
		return writeDao.create(TbGoodsPropertiesGp.class, "TbGoodsPropertiesGp_create", appointment);
	}
	
	public long totalCount(SqlParameter parameter) {
		return readDao.count(TbGoodsPropertiesGp.class, "TbGoodsPropertiesGp_count", parameter);
	}
	
	public Collection<TbGoodsPropertiesGp> page(SqlParameter parameter) {
		return readDao.select(TbGoodsPropertiesGp.class, "TbGoodsPropertiesGp_page", parameter);
	}
	
	public TbGoodsPropertiesGp read(SqlParameter parameter) {
		return readDao.read(TbGoodsPropertiesGp.class, "TbGoodsPropertiesGp_read", parameter);
	}
	
	public int delete(SqlParameter parameter) {
		return writeDao.delete(TbGoodsPropertiesGp.class, "TbGoodsPropertiesGp_delete", parameter);
	}
	
	public int update(SqlParameter parameter) {
		return writeDao.update(TbGoodsPropertiesGp.class, "TbGoodsPropertiesGp_update", parameter);
	}
 
}