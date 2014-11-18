package com.weixin.dao;

import java.util.Collection;

import javax.annotation.Resource;

import org.gitchina.framework.commons.dao.ReadDao;
import org.gitchina.framework.commons.dao.WriteDao;
import org.gitchina.framework.commons.dao.support.SqlParameter;
import org.springframework.stereotype.Repository;




@Repository
public class CoreDao {
	@Resource
	private ReadDao readDao;
	@Resource
	private WriteDao writeDao;
	
}
