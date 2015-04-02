package com.my.entity;
import org.gitchina.framework.commons.dao.entity.Entity;
/**
 * 
 */
public class TbOrderGoods extends Entity{
    /***/
    private String goodsId;
    /***/
    private String goodsNumber;
    /***/
    private String inId;
    /***/
    private String inNumber;
    /***/
    private String goodsCount;
		public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }
		public String getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(String goodsNumber) {
        this.goodsNumber = goodsNumber;
    }
		public String getInId() {
        return inId;
    }

    public void setInId(String inId) {
        this.inId = inId;
    }
		public String getInNumber() {
        return inNumber;
    }

    public void setInNumber(String inNumber) {
        this.inNumber = inNumber;
    }
		public String getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(String goodsCount) {
        this.goodsCount = goodsCount;
    }
}