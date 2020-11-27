package com.capgemini.gos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Admins")
public class Admins {
	@Id
	@Column(name="adminid",length=10)
	private String adminid;
	@Column(name="adminname",length=25)
	private String adminname;
	@Column(name="adminpassword",length=15)
	private String adminpassword;
	
	public Admins() {
		super();
	}
	public Admins(String adminid, String adminname, String adminpassword) {
			this.adminid = adminid;
			this.adminname = adminname;
			this.adminpassword = adminpassword;
		}
	
	public String getAdminid() {
		return adminid;
	}
	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminpassword() {
		return adminpassword;
	}
	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}
	
}