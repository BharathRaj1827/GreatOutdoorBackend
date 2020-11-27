package com.capgemini.gos.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Userdata")
public class Userdata {
	@Id
	private int userId;
	private String userPassword;
	private long userPhoneno;
	private String userEmail;

	public Userdata() {
		super();
		
	}

	public Userdata(int userId, String userPassword, long userPhoneno, String userEmail) {
		super();
		this.userId = userId;
		
		this.userPassword = userPassword;
		this.userPhoneno = userPhoneno;
		this.userEmail = userEmail;
	}

	

	public Userdata(int userId, String userPassword) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public long getUserPhoneno() {
		return userPhoneno;
	}

	public void setUserPhoneno(long userPhoneno) {
		this.userPhoneno = userPhoneno;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	

	
}