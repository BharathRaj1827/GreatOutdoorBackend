package com.capgemini.gos.entity;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "revenuetab")
public class RevenueTable {
	@Column(name = "user_id")
	private String userid;
	private Date date1;
	private int orderid;
	@Id
	private int productid;
	@Column(name = "product_category")
	private String productCategory;
	@Column(name = "product_price")
	private int productPrice;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}
	
	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public RevenueTable(String userid, Date date1, int orderid, int productid, String productCategory,
			int productPrice) {
		super();
		this.userid = userid;
		this.date1 = date1;
		this.orderid = orderid;
		this.productid = productid;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
	}
	public RevenueTable() {
		super();
	}

}
