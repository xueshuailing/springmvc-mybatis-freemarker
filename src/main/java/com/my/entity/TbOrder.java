package com.my.entity;
import org.gitchina.framework.commons.dao.entity.Entity;
/**
 * 
 */
public class TbOrder extends Entity{
    /***/
    private String inNum;
    /***/
    private String userId;
    /**0--支付宝  1--货到付款*/
    private String inPayment;
    /***/
    private String inReceiptId;
    /***/
    private String address;
    /***/
    private String inCommitTime;
    /**0--待付款 1--待发货 2--配送中 3--待评价 4--交易完成 5--退款中 6--交易关闭*/
    private String inState;
    /***/
    private String inSendTime;
    /***/
    private String inReceiptTime;
    /***/
    private String inRefundTime;
    /***/
    private String inRefundFinishTime;
    /***/
    private String inRefundMoney;
    /***/
    private String inCarriage;
    /**0--不要发票 1--个人 2--公司*/
    private String inInvoiceType;
    /***/
    private String inInvoiceCompany;
    /***/
    private String inCancelTime;
    /***/
    private String inPrivilegeMoney;
    /***/
    private String inOriginalMoney;
    /***/
    private String inNowMoney;
    /***/
    private String inZfTime;
    /***/
    private String inName;
    /***/
    private String inReceiptPhone;
		public String getInNum() {
        return inNum;
    }

    public void setInNum(String inNum) {
        this.inNum = inNum;
    }
		public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
		public String getInPayment() {
        return inPayment;
    }

    public void setInPayment(String inPayment) {
        this.inPayment = inPayment;
    }
		public String getInReceiptId() {
        return inReceiptId;
    }

    public void setInReceiptId(String inReceiptId) {
        this.inReceiptId = inReceiptId;
    }
		public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
		public String getInCommitTime() {
        return inCommitTime;
    }

    public void setInCommitTime(String inCommitTime) {
        this.inCommitTime = inCommitTime;
    }
		public String getInState() {
        return inState;
    }

    public void setInState(String inState) {
        this.inState = inState;
    }
		public String getInSendTime() {
        return inSendTime;
    }

    public void setInSendTime(String inSendTime) {
        this.inSendTime = inSendTime;
    }
		public String getInReceiptTime() {
        return inReceiptTime;
    }

    public void setInReceiptTime(String inReceiptTime) {
        this.inReceiptTime = inReceiptTime;
    }
		public String getInRefundTime() {
        return inRefundTime;
    }

    public void setInRefundTime(String inRefundTime) {
        this.inRefundTime = inRefundTime;
    }
		public String getInRefundFinishTime() {
        return inRefundFinishTime;
    }

    public void setInRefundFinishTime(String inRefundFinishTime) {
        this.inRefundFinishTime = inRefundFinishTime;
    }
		public String getInRefundMoney() {
        return inRefundMoney;
    }

    public void setInRefundMoney(String inRefundMoney) {
        this.inRefundMoney = inRefundMoney;
    }
		public String getInCarriage() {
        return inCarriage;
    }

    public void setInCarriage(String inCarriage) {
        this.inCarriage = inCarriage;
    }
		public String getInInvoiceType() {
        return inInvoiceType;
    }

    public void setInInvoiceType(String inInvoiceType) {
        this.inInvoiceType = inInvoiceType;
    }
		public String getInInvoiceCompany() {
        return inInvoiceCompany;
    }

    public void setInInvoiceCompany(String inInvoiceCompany) {
        this.inInvoiceCompany = inInvoiceCompany;
    }
		public String getInCancelTime() {
        return inCancelTime;
    }

    public void setInCancelTime(String inCancelTime) {
        this.inCancelTime = inCancelTime;
    }
		public String getInPrivilegeMoney() {
        return inPrivilegeMoney;
    }

    public void setInPrivilegeMoney(String inPrivilegeMoney) {
        this.inPrivilegeMoney = inPrivilegeMoney;
    }
		public String getInOriginalMoney() {
        return inOriginalMoney;
    }

    public void setInOriginalMoney(String inOriginalMoney) {
        this.inOriginalMoney = inOriginalMoney;
    }
		public String getInNowMoney() {
        return inNowMoney;
    }

    public void setInNowMoney(String inNowMoney) {
        this.inNowMoney = inNowMoney;
    }
		public String getInZfTime() {
        return inZfTime;
    }

    public void setInZfTime(String inZfTime) {
        this.inZfTime = inZfTime;
    }
		public String getInName() {
        return inName;
    }

    public void setInName(String inName) {
        this.inName = inName;
    }
		public String getInReceiptPhone() {
        return inReceiptPhone;
    }

    public void setInReceiptPhone(String inReceiptPhone) {
        this.inReceiptPhone = inReceiptPhone;
    }
}