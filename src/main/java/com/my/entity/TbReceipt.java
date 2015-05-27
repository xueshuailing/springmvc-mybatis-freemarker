package com.my.entity;
import org.gitchina.framework.commons.dao.entity.Entity;
/**
 * 用户收货地址表
 */
public class TbReceipt extends Entity{
    /***/
    private String userId;
    /***/
    private String receiptPhone;
    /**0--不是默认收货地址
            1--是默认收货地址*/
    private String isDefault;
    /***/
    private String address;
    /***/
    private String receiptName;
    /***/
    private String proId;
    /***/
    private String cityId;
    /***/
    private String countId;
		public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
		public String getReceiptPhone() {
        return receiptPhone;
    }

    public void setReceiptPhone(String receiptPhone) {
        this.receiptPhone = receiptPhone;
    }
		public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }
		public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
		public String getReceiptName() {
        return receiptName;
    }

    public void setReceiptName(String receiptName) {
        this.receiptName = receiptName;
    }
		public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }
		public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }
		public String getCountId() {
        return countId;
    }

    public void setCountId(String countId) {
        this.countId = countId;
    }
}