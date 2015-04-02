package com.my.entity;
import org.gitchina.framework.commons.dao.entity.Entity;
/**
 * 
 */
public class TbAccount extends Entity{
    /***/
    private String userId;
    /***/
    private String createDate;
    /***/
    private String money;
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
		public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}