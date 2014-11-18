/*
 * @(#)IEntity.java
 *
 * Copyright 2012 北龙中网（北京）科技有限责任公司. All rights reserved.
 */
package org.gitchina.framework.commons.dao.entity;

import java.io.Serializable;

/**
 * 所有领域对象接口. 
 */
public interface IEntity<PK> extends Serializable {
	
	public long getId();
	
	public void setId(long id);
	
}
