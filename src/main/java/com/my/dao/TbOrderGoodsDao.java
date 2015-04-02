package com.my.dao;
import java.util.Collection;

import javax.annotation.Resource;

import org.gitchina.framework.commons.dao.ReadDao;
import org.gitchina.framework.commons.dao.WriteDao;
import org.gitchina.framework.commons.dao.support.SqlParameter;
import org.springframework.stereotype.Repository;
import com.my.entity.TbOrderGoods;
/**
 * dao层
 */
@Repository
public class TbOrderGoodsDao {
	@Resource
	private ReadDao readDao;
	@Resource
	private WriteDao writeDao;
	public long create(TbOrderGoods appointment) {
		return writeDao.create(TbOrderGoods.class, "TbOrderGoods_create", appointment);
	}
	
	public long totalCount(SqlParameter parameter) {
		return readDao.count(TbOrderGoods.class, "TbOrderGoods_count", parameter);
	}
	
	public Collection<TbOrderGoods> page(SqlParameter parameter) {
		return readDao.select(TbOrderGoods.class, "TbOrderGoods_page", parameter);
	}
	
	public TbOrderGoods read(SqlParameter parameter) {
		return readDao.read(TbOrderGoods.class, "TbOrderGoods_read", parameter);
	}
	
	public int delete(SqlParameter parameter) {
		return writeDao.delete(TbOrderGoods.class, "TbOrderGoods_delete", parameter);
	}
	
	public int update(SqlParameter parameter) {
		return writeDao.update(TbOrderGoods.class, "TbOrderGoods_update", parameter);
	}
 
}