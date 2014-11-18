package xsl.java.create.main;

import freemarker.template.Template;

public class TemplatePackage {
	public TemplatePackage(Template template,String packageName,Type type,JavaType javaType){
		this.packageName=packageName;
		this.template=template;
		this.type=type;
		this.javaType=javaType;
	}
	private Template template;
	private String	packageName;
	private Type type;  
	private JavaType javaType;
	public Template getTemplate() {
		return template;
	}
	public void setTemplate(Template template) {
		this.template = template;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public JavaType getJavaType() {
		return javaType;
	}
	public void setJavaType(JavaType javaType) {
		this.javaType = javaType;
	}
}
