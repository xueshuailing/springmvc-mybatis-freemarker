package com.my.entity;
import org.gitchina.framework.commons.dao.entity.Entity;
/**
 * 家庭收入、支出表
 */
public class TbFinancial extends Entity{
    /**财务的类型（存储的是财务类型表的id）*/
    private String typeId;
    /**金额*/
    private String num;
    /***/
    private String createDate;
    /**该条财务是由哪个家庭成员产生的 存储的是家庭成员的id*/
    private String familyId;
    /**用户id*/
    private String userId;
    /**成员性别 0--男 1--女 主要用来性别统计*/
    private String familySex;
    /***/
    private String familyAge;
    /**是否收入 0--是 1--不是*/
    private String flag;
    /***/
    private String remark;
		public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
		public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
		public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
		public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }
		public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
		public String getFamilySex() {
        return familySex;
    }

    public void setFamilySex(String familySex) {
        this.familySex = familySex;
    }
		public String getFamilyAge() {
        return familyAge;
    }

    public void setFamilyAge(String familyAge) {
        this.familyAge = familyAge;
    }
		public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
		public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}