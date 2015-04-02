package com.my.entity;
import org.gitchina.framework.commons.dao.entity.Entity;
/**
 * 
 */
public class TbGoodsPic extends Entity{
    /***/
    private String goodsOriginalPicUrl;
    /***/
    private String goodsThumbPicUrl;
    /**正序排 数值越小越靠前*/
    private String goodsSort;
    /***/
    private String goodsCreateTime;
    /***/
    private String goodsNumber;
    /**0 不显示 1 显示 同一件商品只能有一张图片是列表展示的*/
    private String isShow;
		public String getGoodsOriginalPicUrl() {
        return goodsOriginalPicUrl;
    }

    public void setGoodsOriginalPicUrl(String goodsOriginalPicUrl) {
        this.goodsOriginalPicUrl = goodsOriginalPicUrl;
    }
		public String getGoodsThumbPicUrl() {
        return goodsThumbPicUrl;
    }

    public void setGoodsThumbPicUrl(String goodsThumbPicUrl) {
        this.goodsThumbPicUrl = goodsThumbPicUrl;
    }
		public String getGoodsSort() {
        return goodsSort;
    }

    public void setGoodsSort(String goodsSort) {
        this.goodsSort = goodsSort;
    }
		public String getGoodsCreateTime() {
        return goodsCreateTime;
    }

    public void setGoodsCreateTime(String goodsCreateTime) {
        this.goodsCreateTime = goodsCreateTime;
    }
		public String getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(String goodsNumber) {
        this.goodsNumber = goodsNumber;
    }
		public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }
}