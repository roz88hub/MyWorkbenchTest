package com.model;

public class User {
		
	public User(String name) {
		super();
		this.name = name;
	}
	private String name;
	private final String company = "DCI/UST";
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	

}
