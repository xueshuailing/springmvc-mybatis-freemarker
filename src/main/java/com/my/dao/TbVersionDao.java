package com.my.dao;
import java.util.Collection;

import javax.annotation.Resource;

import org.gitchina.framework.commons.dao.ReadDao;
import org.gitchina.framework.commons.dao.WriteDao;
import org.gitchina.framework.commons.dao.support.SqlParameter;
import org.springframework.stereotype.Repository;
import com.my.entity.TbVersion;
/**
 * 版本控制表dao层
 */
@Repository
public class TbVersionDao {
	@Resource
	private ReadDao readDao;
	@Resource
	private WriteDao writeDao;
	public long create(TbVersion appointment) {
		return writeDao.create(TbVersion.class, "TbVersion_create", appointment);
	}
	
	public long totalCount(SqlParameter parameter) {
		return readDao.count(TbVersion.class, "TbVersion_count", parameter);
	}
	
	public Collection<TbVersion> page(SqlParameter parameter) {
		return readDao.select(TbVersion.class, "TbVersion_page", parameter);
	}
	
	public TbVersion read(SqlParameter parameter) {
		return readDao.read(TbVersion.class, "TbVersion_read", parameter);
	}
	
	public int delete(SqlParameter parameter) {
		return writeDao.delete(TbVersion.class, "TbVersion_delete", parameter);
	}
	
	public int update(SqlParameter parameter) {
		return writeDao.update(TbVersion.class, "TbVersion_update", parameter);
	}
 
}