package xsl.java.create.main;

import java.util.HashMap;
import java.util.Map;

/**
 * 生成java类的类型
 *
 */
public enum JavaType {
	ENTITY("","实体类"),
	DAO("Dao","dao类"),
	XML("","配置文件"),
	JSP("","jsp"),
	CONTROLLER("Controller","controller类"),
	SERVICE("Service","service类")
	;
	
	 JavaType(String code, String value) {
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
	
	private static Map<String,JavaType> MAPPING = new HashMap<String,JavaType>();
	
	static {
		for (JavaType model : JavaType.values()) {
			MAPPING.put(model.getCode(), model);
		}
	}
	
	public static JavaType forCode(int code) {
		return MAPPING.get(code);
	}
	
	public static JavaType forText(String text) {
		for (JavaType model : JavaType.values()) {
			if (model.getText().equals(text)) {
				return model;
			}
		}
		return null;
	}
}
