package com.my.entity;
import org.gitchina.framework.commons.dao.entity.Entity;
/**
 * 
 */
public class Province extends Entity{
    /***/
    private String proId;
    /***/
    private String proName;
    /***/
    private String proSort;
    /***/
    private String proRemark;
		public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }
		public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }
		public String getProSort() {
        return proSort;
    }

    public void setProSort(String proSort) {
        this.proSort = proSort;
    }
		public String getProRemark() {
        return proRemark;
    }

    public void setProRemark(String proRemark) {
        this.proRemark = proRemark;
    }
}