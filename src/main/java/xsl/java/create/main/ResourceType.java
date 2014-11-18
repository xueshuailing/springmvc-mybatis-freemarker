package xsl.java.create.main;

import java.util.HashMap;
import java.util.Map;

/**
 * 资源类型
 *
 */
public enum ResourceType {
	JAVA("/src/main/java/","代码"),
	JSP("/src/main/webapp/WEB-INF/","jsp"),
	RESOURCE("/src/main/resources/","资源")
	;
	
	 ResourceType(String code, String value) {
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
	
	private static Map<String,ResourceType> MAPPING = new HashMap<String,ResourceType>();
	
	static {
		for (ResourceType model : ResourceType.values()) {
			MAPPING.put(model.getCode(), model);
		}
	}
	
	public static ResourceType forCode(int code) {
		return MAPPING.get(code);
	}
	
	public static ResourceType forText(String text) {
		for (ResourceType model : ResourceType.values()) {
			if (model.getText().equals(text)) {
				return model;
			}
		}
		return null;
	}
}
