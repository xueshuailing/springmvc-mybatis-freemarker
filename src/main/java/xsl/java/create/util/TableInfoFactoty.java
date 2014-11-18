package xsl.java.create.util;

import java.sql.Connection;

import xsl.java.create.service.DbMetaData;
import xsl.java.create.service.impl.MysqlMetaData;
import xsl.java.create.view.main.db.DbType;

/**
 * User: lxw Date: 14-3-13 下午1:14 工厂方法，创建不同的DB的实例化类
 */
public class TableInfoFactoty {
	/**
	 * 根据DB类型取得当前对应类型的实例化类
	 *
	 * @param connection
	 * @param dbType
	 * @return
	 */
	public static DbMetaData getDbMetaData(Connection connection, DbType dbType, String dbName) {

		switch (dbType) {
		case MYSQL:
			return new MysqlMetaData(connection, dbName);
		case ORACLE:
			return null;
		case SQLSERVER:
			return null;
		default:
			throw new RuntimeException("尚不支持该类型的数据库");
		}
	}
}
