package com.my.dao;
import java.util.Collection;

import javax.annotation.Resource;

import org.gitchina.framework.commons.dao.ReadDao;
import org.gitchina.framework.commons.dao.WriteDao;
import org.gitchina.framework.commons.dao.support.SqlParameter;
import org.springframework.stereotype.Repository;
import com.my.entity.TbMarketClassify;
/**
 * dao层
 */
@Repository
public class TbMarketClassifyDao {
	@Resource
	private ReadDao readDao;
	@Resource
	private WriteDao writeDao;
	public long create(TbMarketClassify appointment) {
		return writeDao.create(TbMarketClassify.class, "TbMarketClassify_create", appointment);
	}
	
	public long totalCount(SqlParameter parameter) {
		return readDao.count(TbMarketClassify.class, "TbMarketClassify_count", parameter);
	}
	
	public Collection<TbMarketClassify> page(SqlParameter parameter) {
		return readDao.select(TbMarketClassify.class, "TbMarketClassify_page", parameter);
	}
	
	public TbMarketClassify read(SqlParameter parameter) {
		return readDao.read(TbMarketClassify.class, "TbMarketClassify_read", parameter);
	}
	
	public int delete(SqlParameter parameter) {
		return writeDao.delete(TbMarketClassify.class, "TbMarketClassify_delete", parameter);
	}
	
	public int update(SqlParameter parameter) {
		return writeDao.update(TbMarketClassify.class, "TbMarketClassify_update", parameter);
	}
 
}