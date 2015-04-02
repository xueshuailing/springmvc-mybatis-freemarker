package com.my.dao;
import java.util.Collection;

import javax.annotation.Resource;

import org.gitchina.framework.commons.dao.ReadDao;
import org.gitchina.framework.commons.dao.WriteDao;
import org.gitchina.framework.commons.dao.support.SqlParameter;
import org.springframework.stereotype.Repository;
import com.my.entity.TbClassifyGoods;
/**
 * dao层
 */
@Repository
public class TbClassifyGoodsDao {
	@Resource
	private ReadDao readDao;
	@Resource
	private WriteDao writeDao;
	public long create(TbClassifyGoods appointment) {
		return writeDao.create(TbClassifyGoods.class, "TbClassifyGoods_create", appointment);
	}
	
	public long totalCount(SqlParameter parameter) {
		return readDao.count(TbClassifyGoods.class, "TbClassifyGoods_count", parameter);
	}
	
	public Collection<TbClassifyGoods> page(SqlParameter parameter) {
		return readDao.select(TbClassifyGoods.class, "TbClassifyGoods_page", parameter);
	}
	
	public TbClassifyGoods read(SqlParameter parameter) {
		return readDao.read(TbClassifyGoods.class, "TbClassifyGoods_read", parameter);
	}
	
	public int delete(SqlParameter parameter) {
		return writeDao.delete(TbClassifyGoods.class, "TbClassifyGoods_delete", parameter);
	}
	
	public int update(SqlParameter parameter) {
		return writeDao.update(TbClassifyGoods.class, "TbClassifyGoods_update", parameter);
	}
 
}