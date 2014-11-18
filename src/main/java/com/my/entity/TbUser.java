package com.my.entity;
import org.gitchina.framework.commons.dao.entity.Entity;
/**
 * 用户注册表（家庭成员管理员表）
 */
public class TbUser extends Entity{
    /**姓名*/
    private String name;
    /**年龄*/
    private String age;
    /**性别 0--男 1--女*/
    private String sex;
    /**邮箱*/
    private String email;
    /**手机号*/
    private String phone;
    /**密码*/
    private String password;
    /**创建时间*/
    private String time;
    /**是否激活 0--未激活 1--激活*/
    private String state;
    /**激活码*/
    private String number;
    /**到期时间*/
    private String endTime;
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
		public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
		public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
		public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
		public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
		public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
		public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
		public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
		public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}