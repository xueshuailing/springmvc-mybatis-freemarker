package com.my.entity;
import org.gitchina.framework.commons.dao.entity.Entity;
/**
 * 收入、支出类型字典表
 */
public class TbType extends Entity{
    /**0--收入 1--支出*/
    private String type;
    /**名称*/
    private String name;
    /**用户id*/
    private String userId;
    /***/
    private String createDate;
		public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
		public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
		public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
		public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}