package org.gitchina.framework.commons.dao.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.gitchina.framework.commons.dao.WriteDao;
import org.gitchina.framework.commons.dao.entity.Entity;
import org.gitchina.framework.commons.dao.support.SqlParameter;
import org.mybatis.spring.SqlSessionTemplate;

public class WriteDaoImpl implements WriteDao {
	@Resource
	public SqlSessionTemplate sqlSession;

	 

	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int create(Class<?> clazz, final String sqlId, Entity t) {
		return sqlSession.insert(sqlId, t);
	}

	@Override
	public int saveOrUpdate(Class<?> clazz, final String createSqlId,
			final String updateSqlId, Entity t) {
		int value = update(clazz, updateSqlId, t);
		if (value > 0) {
			return value;
		}
		return create(clazz, createSqlId, t);
	}

	@Override
	public int update(Class<?> clazz, final String sqlId, Entity t) {
		return sqlSession.update(sqlId, t);
	}

	@Override
	public int update(Class<?> clazz, String sqlId, SqlParameter parameter) {
		return sqlSession.update(sqlId, parameter.getCriteria());
	}

	@Override
	public int delete(Class<?> clazz, String sqlId, long parameter) {
		return sqlSession.delete(sqlId, parameter);
	}

	@Override
	public int delete(Class<?> clazz, String sqlId, String parameter) {
		return sqlSession.delete(sqlId, parameter);
	}

	@Override
	public int delete(Class<?> clazz, String sqlId, SqlParameter parameter) {
		return sqlSession.delete(sqlId, parameter.getCriteria());
	}

	@Override
	public void batch(Class<?> clazz, final String sqlId, Collection<?> list) {
		sqlSession.insert(sqlId, list);
	}

	@Override
	public int update(Class<?> clazz, String sqlId, long value) {
		return sqlSession.update(sqlId, value);
	}

	@Override
	public int update(Class<?> clazz, String sqlId, String value) {
		return sqlSession.update(sqlId, value);
	}
}
