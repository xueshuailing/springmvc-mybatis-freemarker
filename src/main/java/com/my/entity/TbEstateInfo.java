package com.my.entity;
import org.gitchina.framework.commons.dao.entity.Entity;
/**
 * 
 */
public class TbEstateInfo extends Entity{
    /***/
    private String title;
    /***/
    private String content;
    /***/
    private String estateId;
    /***/
    private String createTime;
		public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
		public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
		public String getEstateId() {
        return estateId;
    }

    public void setEstateId(String estateId) {
        this.estateId = estateId;
    }
		public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}