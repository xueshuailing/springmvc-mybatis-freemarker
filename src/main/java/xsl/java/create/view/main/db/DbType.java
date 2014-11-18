package xsl.java.create.view.main.db;

/**
 * @author lixiuwen
 * Description: 
 * 
 * Company: Gzzhongtu Software ltd.
 * @date 2014-7-30上午11:21:15
 * @version v1.0
 * 
 */
public enum DbType {
	MYSQL("mysql", 1), SQLSERVER("SqlServer", 2), ORACLE("Oracle", 3);

	private String name;
	private int ordinal;

	
	private DbType(String name, int ordinal) {
		this.name = name;
		this.ordinal = ordinal;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getOrdinal() {
		return ordinal;
	}


	public void setOrdinal(int ordinal) {
		this.ordinal = ordinal;
	}
	
	@Override
	public String toString(){
		return this.name;
	}
	
}
