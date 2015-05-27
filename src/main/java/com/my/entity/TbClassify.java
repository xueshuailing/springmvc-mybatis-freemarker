package com.my.entity;
import org.gitchina.framework.commons.dao.entity.Entity;
/**
 * 
 */
public class TbClassify extends Entity{
    /***/
    private String name;
    /***/
    private String parentId;
    /***/
    private String url;
		public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
		public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
		public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}