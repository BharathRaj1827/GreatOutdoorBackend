package com.capgemini.gos.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "wishlist")
public class Wishlist {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(generator = "whistlist_roll1d_gen",strategy = GenerationType.SEQUENCE)
	@Column(name = "whistlist_roll1d")
	private int wishlistId;

	@Column(name = "product_name")
	private String productName;
	
	
	public Wishlist() {
		
	}

	public Wishlist(int wishlistId, String productName) {
		
		this.wishlistId = wishlistId;
		this.productName = productName;
		
	}

	

	public int getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(int wishlistId) {
		this.wishlistId = wishlistId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	
	

}

