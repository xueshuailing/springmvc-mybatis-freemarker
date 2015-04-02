package com.my.dao;
import java.util.Collection;

import javax.annotation.Resource;

import org.gitchina.framework.commons.dao.ReadDao;
import org.gitchina.framework.commons.dao.WriteDao;
import org.gitchina.framework.commons.dao.support.SqlParameter;
import org.springframework.stereotype.Repository;
import com.my.entity.TbGoodsPropertiesClassify;
/**
 * dao层
 */
@Repository
public class TbGoodsPropertiesClassifyDao {
	@Resource
	private ReadDao readDao;
	@Resource
	private WriteDao writeDao;
	public long create(TbGoodsPropertiesClassify appointment) {
		return writeDao.create(TbGoodsPropertiesClassify.class, "TbGoodsPropertiesClassify_create", appointment);
	}
	
	public long totalCount(SqlParameter parameter) {
		return readDao.count(TbGoodsPropertiesClassify.class, "TbGoodsPropertiesClassify_count", parameter);
	}
	
	public Collection<TbGoodsPropertiesClassify> page(SqlParameter parameter) {
		return readDao.select(TbGoodsPropertiesClassify.class, "TbGoodsPropertiesClassify_page", parameter);
	}
	
	public TbGoodsPropertiesClassify read(SqlParameter parameter) {
		return readDao.read(TbGoodsPropertiesClassify.class, "TbGoodsPropertiesClassify_read", parameter);
	}
	
	public int delete(SqlParameter parameter) {
		return writeDao.delete(TbGoodsPropertiesClassify.class, "TbGoodsPropertiesClassify_delete", parameter);
	}
	
	public int update(SqlParameter parameter) {
		return writeDao.update(TbGoodsPropertiesClassify.class, "TbGoodsPropertiesClassify_update", parameter);
	}
 
}