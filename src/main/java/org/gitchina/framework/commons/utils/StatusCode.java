package org.gitchina.framework.commons.utils;

import java.util.HashMap;
import java.util.Map;

public enum StatusCode {

	OK(200, "ok"),
	Error(500, "error"),
	UserNotFound(404, "用户不存在");
	;
	
	StatusCode(Integer code, String value) {
		this.code = code;
		this.value = value;
	}
	
	private Integer code;
	private String value;
	
	public String getText() {
		return value;
	}

	public Integer getCode() {
		return code;
	}
	
	private static Map<Integer,StatusCode> MAPPING = new HashMap<Integer,StatusCode>();
	
	static {
		for (StatusCode model : StatusCode.values()) {
			MAPPING.put(model.getCode(), model);
		}
	}
	
	public static StatusCode forCode(int code) {
		return MAPPING.get(code);
	}
	
	public static StatusCode forText(String text) {
		for (StatusCode model : StatusCode.values()) {
			if (model.getText().equals(text)) {
				return model;
			}
		}
		return null;
	}
}