package com.my.entity;
import org.gitchina.framework.commons.dao.entity.Entity;
/**
 * 
 */
public class TbFeedback extends Entity{
    /**联系方式*/
    private String phone;
    /**反馈内容*/
    private String opinion;
    /**员工id*/
    private String userId;
    /**创建时间*/
    private String dateTime;
    /***/
    private String userName;
		public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
		public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
		public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
		public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
		public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}