package com.my.entity;
import org.gitchina.framework.commons.dao.entity.Entity;
/**
 * 
 */
public class TbFoodsafety extends Entity{
    /***/
    private String title;
    /***/
    private String createDate;
    /***/
    private String content;
		public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
		public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
		public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}