package com.my.entity;
import org.gitchina.framework.commons.dao.entity.Entity;
/**
 * 
 */
public class TbEstate extends Entity{
    /***/
    private String createDate;
    /***/
    private String name;
    /***/
    private String introduction;
    /***/
    private String address;
    /***/
    private String proId;
    /***/
    private String countId;
    /***/
    private String cityId;
		public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
		public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
		public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
		public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
		public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }
		public String getCountId() {
        return countId;
    }

    public void setCountId(String countId) {
        this.countId = countId;
    }
		public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }
}