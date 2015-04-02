package com.my.entity;
import org.gitchina.framework.commons.dao.entity.Entity;
/**
 * 版本控制表
 */
public class TbVersion extends Entity{
    /**存放版本例如 1 、 2、  3*/
    private String versionCode;
    /**存放版本号 例如 1.2.3*/
    private String versionName;
    /**版本升级更新内容*/
    private String versionUpdate;
    /**app大小*/
    private String versionSize;
    /**更新url路径*/
    private String versionUrl;
    /**时间*/
    private String versionTime;
    /**类型 0--安卓 1--苹果*/
    private String versionType;
		public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }
		public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }
		public String getVersionUpdate() {
        return versionUpdate;
    }

    public void setVersionUpdate(String versionUpdate) {
        this.versionUpdate = versionUpdate;
    }
		public String getVersionSize() {
        return versionSize;
    }

    public void setVersionSize(String versionSize) {
        this.versionSize = versionSize;
    }
		public String getVersionUrl() {
        return versionUrl;
    }

    public void setVersionUrl(String versionUrl) {
        this.versionUrl = versionUrl;
    }
		public String getVersionTime() {
        return versionTime;
    }

    public void setVersionTime(String versionTime) {
        this.versionTime = versionTime;
    }
		public String getVersionType() {
        return versionType;
    }

    public void setVersionType(String versionType) {
        this.versionType = versionType;
    }
}