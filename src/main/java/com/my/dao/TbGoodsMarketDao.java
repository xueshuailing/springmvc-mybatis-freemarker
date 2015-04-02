package com.my.dao;
import java.util.Collection;

import javax.annotation.Resource;

import org.gitchina.framework.commons.dao.ReadDao;
import org.gitchina.framework.commons.dao.WriteDao;
import org.gitchina.framework.commons.dao.support.SqlParameter;
import org.springframework.stereotype.Repository;
import com.my.entity.TbGoodsMarket;
/**
 * dao层
 */
@Repository
public class TbGoodsMarketDao {
	@Resource
	private ReadDao readDao;
	@Resource
	private WriteDao writeDao;
	public long create(TbGoodsMarket appointment) {
		return writeDao.create(TbGoodsMarket.class, "TbGoodsMarket_create", appointment);
	}
	
	public long totalCount(SqlParameter parameter) {
		return readDao.count(TbGoodsMarket.class, "TbGoodsMarket_count", parameter);
	}
	
	public Collection<TbGoodsMarket> page(SqlParameter parameter) {
		return readDao.select(TbGoodsMarket.class, "TbGoodsMarket_page", parameter);
	}
	
	public TbGoodsMarket read(SqlParameter parameter) {
		return readDao.read(TbGoodsMarket.class, "TbGoodsMarket_read", parameter);
	}
	
	public int delete(SqlParameter parameter) {
		return writeDao.delete(TbGoodsMarket.class, "TbGoodsMarket_delete", parameter);
	}
	
	public int update(SqlParameter parameter) {
		return writeDao.update(TbGoodsMarket.class, "TbGoodsMarket_update", parameter);
	}
 
}