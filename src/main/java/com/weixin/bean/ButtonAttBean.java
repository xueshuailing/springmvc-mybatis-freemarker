package com.weixin.bean;

import java.util.List;

public class ButtonAttBean {
	/**
	 * 类型
	 * click view
	 */
	private String type;
	/**
	 * 菜单名称
	 */
	private String name;
	/**
	 * key
	 */
	private String key;
	/**
	 * url
	 */
	private String url;
	private List<ButtonAttBean> sub_button;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<ButtonAttBean> getSub_button() {
		return sub_button;
	}
	public void setSub_button(List<ButtonAttBean> subButton) {
		sub_button = subButton;
	}
}
