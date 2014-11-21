package org.gitchina.framework.commons.dao.impl;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Resource;

import org.gitchina.framework.commons.dao.ReadDao;
import org.gitchina.framework.commons.dao.support.SqlParameter;
import org.mybatis.spring.SqlSessionTemplate;

public class ReadDaoImpl implements ReadDao {
	@Resource
	public SqlSessionTemplate sqlSession;

	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public <T> T read(Class<T> clazz, String sqlId, long parameter) {
		return sqlSession.selectOne(sqlId, parameter);
	}

	@Override
	public <T> T read(Class<T> clazz, String sqlId, String parameter) {
		return sqlSession.selectOne(sqlId, parameter);
	}

	@Override
	public <T> T read(Class<T> clazz, String sqlId, SqlParameter parameter) {
		return sqlSession.selectOne(sqlId, parameter.getCriteria());
	}

	@Override
	public long count(Class<?> clazz, String sqlId, long parameter) {
		Long val = sqlSession.selectOne(sqlId, parameter);
		return (val == null) ? 0 : val;
	}

	@Override
	public long count(Class<?> clazz, String sqlId, String parameter) {
		Long val = sqlSession.selectOne(sqlId, parameter);
		return (val == null) ? 0 : val;
	}

	@Override
	public long count(Class<?> clazz, String sqlId, SqlParameter parameter) {
		Long val = sqlSession.selectOne(sqlId, parameter.getCriteria());
		return (val == null) ? 0 : val;
	}

	@Override
	public <T> Collection<T> select(Class<T> clazz, String sqlId, long parameter) {
		return sqlSession.selectList(sqlId, parameter);
	}

	@Override
	public <T> Collection<T> select(Class<T> clazz, String sqlId,
			String parameter) {
		return sqlSession.selectList(sqlId, parameter);
	}

	@Override
	public <T> Collection<T> select(Class<T> clazz, String sqlId,
			SqlParameter parameter) {
		return sqlSession.selectList(sqlId, parameter.getCriteria());
	}

	public <T, E> Map<T, E> selectMap(String sqlId, SqlParameter parameter,
			String mapKey) {
		return sqlSession.selectMap(sqlId, parameter.getCriteria(), mapKey);
	}

	public <T, E> Map<T, E> selectMap(String sqlId, long parameter,
			String mapKey) {
		return sqlSession.selectMap(sqlId, parameter, mapKey);
	}

	public <T, E> Map<T, E> selectMap(String sqlId, String parameter,
			String mapKey) {
		return sqlSession.selectMap(sqlId, parameter, mapKey);
	}
}
