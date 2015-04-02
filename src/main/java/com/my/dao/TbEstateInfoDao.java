package com.my.dao;
import java.util.Collection;

import javax.annotation.Resource;

import org.gitchina.framework.commons.dao.ReadDao;
import org.gitchina.framework.commons.dao.WriteDao;
import org.gitchina.framework.commons.dao.support.SqlParameter;
import org.springframework.stereotype.Repository;
import com.my.entity.TbEstateInfo;
/**
 * dao层
 */
@Repository
public class TbEstateInfoDao {
	@Resource
	private ReadDao readDao;
	@Resource
	private WriteDao writeDao;
	public long create(TbEstateInfo appointment) {
		return writeDao.create(TbEstateInfo.class, "TbEstateInfo_create", appointment);
	}
	
	public long totalCount(SqlParameter parameter) {
		return readDao.count(TbEstateInfo.class, "TbEstateInfo_count", parameter);
	}
	
	public Collection<TbEstateInfo> page(SqlParameter parameter) {
		return readDao.select(TbEstateInfo.class, "TbEstateInfo_page", parameter);
	}
	
	public TbEstateInfo read(SqlParameter parameter) {
		return readDao.read(TbEstateInfo.class, "TbEstateInfo_read", parameter);
	}
	
	public int delete(SqlParameter parameter) {
		return writeDao.delete(TbEstateInfo.class, "TbEstateInfo_delete", parameter);
	}
	
	public int update(SqlParameter parameter) {
		return writeDao.update(TbEstateInfo.class, "TbEstateInfo_update", parameter);
	}
 
}