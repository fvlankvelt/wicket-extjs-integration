package de.fj.wickx.data;


public class ExtField {

	private String name;
	private Class<?> type;
	private String dateFormat;

	
	public ExtField(String name) {
		this(name, null);
	}

	public ExtField(String name, Class<?> type) {
		this(name, type, null);
	}
	
	public ExtField(String name, Class<?> type, String dateFormat) {
		this.name = name;
		this.type = type;
		this.dateFormat = dateFormat;
	}
	

	public String getName() {
		return name;
	}
	
	public Class<?> getType() {
		return type;
	}
	
	public String getDateFormat() {
		return dateFormat;
	}

}
