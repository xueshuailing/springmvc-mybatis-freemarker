package com.my.entity;
import org.gitchina.framework.commons.dao.entity.Entity;
/**
 * 
 */
public class City extends Entity{
    /***/
    private String cityId;
    /***/
    private String cityName;
    /***/
    private String proId;
    /***/
    private String citySort;
		public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }
		public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
		public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }
		public String getCitySort() {
        return citySort;
    }

    public void setCitySort(String citySort) {
        this.citySort = citySort;
    }
}