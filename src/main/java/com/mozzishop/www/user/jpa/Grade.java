package com.mozzishop.www.user.jpa;

public enum Grade {
	
	USER("user"),
	CREATOR("creator"),
	ADMIN("admin");
	
	private final String ROLE_PREFIX = "ROLE_";
	private String grade;
	
	Grade(String grade){
		this.grade = grade;
	}
	
	public String getGradeType() {
		return ROLE_PREFIX + grade.toUpperCase(); 
	}
	
	public String getValue() {
		return grade;
	}
	
	public boolean isEqueals(String authority) {
		return this.grade.equals(authority);
	}

}
