package xsl.java.create.main;

import java.util.HashMap;
import java.util.Map;

/**
 * 生成的类型
 *
 */
public enum Type {
	JAVA("java","代码"),
	JSP("jsp","jsp"),
	XML("xml","配置文件")
	;
	
	 Type(String code, String value) {
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
	
	private static Map<String,Type> MAPPING = new HashMap<String,Type>();
	
	static {
		for (Type model : Type.values()) {
			MAPPING.put(model.getCode(), model);
		}
	}
	
	public static Type forCode(int code) {
		return MAPPING.get(code);
	}
	
	public static Type forText(String text) {
		for (Type model : Type.values()) {
			if (model.getText().equals(text)) {
				return model;
			}
		}
		return null;
	}
}
