package ${packageName};
import java.util.Collection;

import javax.annotation.Resource;

import org.gitchina.framework.commons.dao.ReadDao;
import org.gitchina.framework.commons.dao.WriteDao;
import org.gitchina.framework.commons.dao.support.SqlParameter;
import org.springframework.stereotype.Repository;
import ${entityPackageName}${"."}${tableInfo.getTableClassName()};
/**
 * ${tableInfo.tableRemark}dao层
 */
@Repository
public class ${tableInfo.getTableClassName()}Dao {
	@Resource
	private ReadDao readDao;
	@Resource
	private WriteDao writeDao;
	public long create(${tableInfo.getTableClassName()} appointment) {
		return writeDao.create(${tableInfo.getTableClassName()}.class, "${tableInfo.getTableClassName()}_create", appointment);
	}
	
	public long totalCount(SqlParameter parameter) {
		return readDao.count(${tableInfo.getTableClassName()}.class, "${tableInfo.getTableClassName()}_count", parameter);
	}
	
	public Collection<${tableInfo.getTableClassName()}> page(SqlParameter parameter) {
		return readDao.select(${tableInfo.getTableClassName()}.class, "${tableInfo.getTableClassName()}_page", parameter);
	}
	
	public ${tableInfo.getTableClassName()} read(SqlParameter parameter) {
		return readDao.read(${tableInfo.getTableClassName()}.class, "${tableInfo.getTableClassName()}_read", parameter);
	}
	
	public int delete(SqlParameter parameter) {
		return writeDao.delete(${tableInfo.getTableClassName()}.class, "${tableInfo.getTableClassName()}_delete", parameter);
	}
	
	public int update(SqlParameter parameter) {
		return writeDao.update(${tableInfo.getTableClassName()}.class, "${tableInfo.getTableClassName()}_update", parameter);
	}
 
}