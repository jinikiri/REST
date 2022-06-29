package com.in28minutes.rest.webservices.RestFulwebservices.user;

import java.sql.Date;

public class User {

	private Integer id;
	private String name;
	private String birthDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User(String birthDate) {
		super();
		this.birthDate = birthDate;
	}
	public User(Integer id, String name, String birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	
}
