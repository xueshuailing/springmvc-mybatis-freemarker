package com.my.dao;
import java.util.Collection;

import javax.annotation.Resource;

import org.gitchina.framework.commons.dao.ReadDao;
import org.gitchina.framework.commons.dao.WriteDao;
import org.gitchina.framework.commons.dao.support.SqlParameter;
import org.springframework.stereotype.Repository;
import com.my.entity.TbGoods;
/**
 * dao层
 */
@Repository
public class TbGoodsDao {
	@Resource
	private ReadDao readDao;
	@Resource
	private WriteDao writeDao;
	public long create(TbGoods appointment) {
		return writeDao.create(TbGoods.class, "TbGoods_create", appointment);
	}
	
	public long totalCount(SqlParameter parameter) {
		return readDao.count(TbGoods.class, "TbGoods_count", parameter);
	}
	
	public Collection<TbGoods> page(SqlParameter parameter) {
		return readDao.select(TbGoods.class, "TbGoods_page", parameter);
	}
	
	public TbGoods read(SqlParameter parameter) {
		return readDao.read(TbGoods.class, "TbGoods_read", parameter);
	}
	
	public int delete(SqlParameter parameter) {
		return writeDao.delete(TbGoods.class, "TbGoods_delete", parameter);
	}
	
	public int update(SqlParameter parameter) {
		return writeDao.update(TbGoods.class, "TbGoods_update", parameter);
	}
 
}