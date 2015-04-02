package com.my.entity;
import org.gitchina.framework.commons.dao.entity.Entity;
/**
 * 
 */
public class OrderComment extends Entity{
    /***/
    private String userId;
    /***/
    private String commentTime;
    /***/
    private String commentCotent;
    /**0-不-显示 1--显示*/
    private String isShow;
    /***/
    private String indentId;
    /***/
    private String name;
		public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
		public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }
		public String getCommentCotent() {
        return commentCotent;
    }

    public void setCommentCotent(String commentCotent) {
        this.commentCotent = commentCotent;
    }
		public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }
		public String getIndentId() {
        return indentId;
    }

    public void setIndentId(String indentId) {
        this.indentId = indentId;
    }
		public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}