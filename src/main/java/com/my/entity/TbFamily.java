package com.my.entity;
import org.gitchina.framework.commons.dao.entity.Entity;
/**
 * 家庭成员表
 */
public class TbFamily extends Entity{
    /**姓名*/
    private String name;
    /**性别 0--男 1--女*/
    private String sex;
    /***/
    private String userId;
    /***/
    private String createDate;
    /***/
    private String age;
		public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
		public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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
		public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}