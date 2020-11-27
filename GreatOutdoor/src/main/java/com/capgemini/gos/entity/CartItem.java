package com.capgemini.gos.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;


@Entity
@Table(name="cart_table")

public class CartItem {
	
	
	@Id
	@Column(name="cart_id")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_id_seq")
	private long cartId;
	@Column(name="user_id", nullable=false)
	private String userId;
	@Column(name="product_id",nullable=false)
	private String productId;
	@Column(name="cart_item_price",nullable=false)
	private double cartItemPrice;
	@Column(name="quantity",nullable=false)
	private long quantity;
	
	
	
	public CartItem(long cartId, String userId, String productId, double cartItemPrice, long quantity) {
		super();
		this.cartId=cartId;
		this.userId=userId;
		this.productId=productId;
		this.cartItemPrice= cartItemPrice;
		this.quantity=quantity;
		
		
	}
	
	
	public CartItem() {
		super();
	}


	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public double getCartItemPrice() {
		return cartItemPrice;
	}
	public void setCartItemPrice(double cartItemPrice) {
		this.cartItemPrice = cartItemPrice;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "CartItem [cartId=" + cartId + ", userId=" + userId + ", productId=" + productId + ", cartItemPrice="
				+ cartItemPrice + ", quantity=" + quantity + "]";
	}

	
}
