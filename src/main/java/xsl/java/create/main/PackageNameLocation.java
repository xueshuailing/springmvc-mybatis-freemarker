package xsl.java.create.main;

import java.util.HashMap;
import java.util.Map;

/**
 * 包名类型
 *
 */
public enum PackageNameLocation {
	INTERCEPURL("my","配置spring拦截器的统一名字"),
	JSPURL("my","配置jsp默认跳转的根目录<在web-info 下面的>"),
	ENTITY("com.my.entity","生成实体类的包路径"),
	MYBATIS("configure.mybatis.orm","生成mybatis配置文件的路径"),
	DB("","生成数据库文档"),
	JSP("","生成jsp文件路径"),
	DAO("com.my.dao","生成dao层的包路径"),
	SERVICE("com.my.service","生成service层的包路径"),
	CONTROLLER("com.my.controller","生成controller层的包路径"),
	MAPPER("configure.mybatis.orm.mapper","生成mybatis配置文件路径 带resultMap的那个配置")
	;
	
	 PackageNameLocation(String code, String value) {
		this.code = code;
		this.value = value;
	}
	
	private String code;
	private String value;
	
	public String getText() {
		return value;
	}

	public String getCode() {
		return code;
	}
	
	private static Map<String,PackageNameLocation> MAPPING = new HashMap<String,PackageNameLocation>();
	
	static {
		for (PackageNameLocation model : PackageNameLocation.values()) {
			MAPPING.put(model.getCode(), model);
		}
	}
	
	public static PackageNameLocation forCode(int code) {
		return MAPPING.get(code);
	}
	
	public static PackageNameLocation forText(String text) {
		for (PackageNameLocation model : PackageNameLocation.values()) {
			if (model.getText().equals(text)) {
				return model;
			}
		}
		return null;
	}
}
