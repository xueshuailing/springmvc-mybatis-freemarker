package com.my.entity;
import org.gitchina.framework.commons.dao.entity.Entity;
/**
 * 
 */
public class TbGoodsPropertiesGp extends Entity{
    /***/
    private String goodsId;
    /***/
    private String propertiesId;
		public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }
		public String getPropertiesId() {
        return propertiesId;
    }

    public void setPropertiesId(String propertiesId) {
        this.propertiesId = propertiesId;
    }
}