package com.my.entity;
import org.gitchina.framework.commons.dao.entity.Entity;
/**
 * 
 */
public class Count extends Entity{
    /***/
    private String countName;
    /***/
    private String cityId;
    /***/
    private String countSort;
		public String getCountName() {
        return countName;
    }

    public void setCountName(String countName) {
        this.countName = countName;
    }
		public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }
		public String getCountSort() {
        return countSort;
    }

    public void setCountSort(String countSort) {
        this.countSort = countSort;
    }
}