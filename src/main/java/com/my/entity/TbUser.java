package com.my.entity;
import org.gitchina.framework.commons.dao.entity.Entity;
/**
 * 
 */
public class TbUser extends Entity{
    /***/
    private String userName;
    /***/
    private String userPassword;
    /***/
    private String position;
    /***/
    private String phoneNumber;
    /***/
    private String email;
    /***/
    private String sex;
    /***/
    private String name;
    /***/
    private String age;
    /***/
    private String address;
    /***/
    private String userBigLogo;
    /***/
    private String userSmallLogo;
    /***/
    private String jpushId;
    /***/
    private String balance;
    /***/
    private String createTime;
    /***/
    private String type;
		public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
		public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
		public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
		public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
		public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
		public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
		public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
		public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
		public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
		public String getUserBigLogo() {
        return userBigLogo;
    }

    public void setUserBigLogo(String userBigLogo) {
        this.userBigLogo = userBigLogo;
    }
		public String getUserSmallLogo() {
        return userSmallLogo;
    }

    public void setUserSmallLogo(String userSmallLogo) {
        this.userSmallLogo = userSmallLogo;
    }
		public String getJpushId() {
        return jpushId;
    }

    public void setJpushId(String jpushId) {
        this.jpushId = jpushId;
    }
		public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
		public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
		public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}