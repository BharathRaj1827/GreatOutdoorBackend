package com.capgemini.gos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

@Entity
@Table(name = "productdata")
public class Product {
	
	@Id
	@NotNull
	
  // @Pattern(regexp = "^[A-Za-z0-9]+$")
	private String id;
	
	@Column(name="price")
	private double price;
	
	@Column(name="colour")
	private String colour;
	
	@Column(name="dimensions")
	private String dimensions;
	
	@Column(name="specifications")	
	private String specifications;
	
	@Column(name="manufacture")
	private String manufacture;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="productCategory")
	private String  productCategory;
	
	@Column(name="productName")
	private String productName;
	
	@Column(name="retailerId")	
	private int retailerId;
	public Product() {
		super();
	}
	public Product(String id, double price, String colour, String dimensions, String specifications, String manufacture,
			int quantity, String productCategory, String productName, int retailerId) {
		super();
		this.id = id;
		this.price = price;
		this.colour = colour;
		this.dimensions = dimensions;
		this.specifications = specifications;
		this.manufacture = manufacture;
		this.quantity = quantity;
		this.productCategory = productCategory;
		this.productName = productName;
		this.retailerId = retailerId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getDimensions() {
		return dimensions;
	}
	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}
	public String getSpecifications() {
		return specifications;
	}
	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getRetailerId() {
		return retailerId;
	}
	public void setRetailerId(int retailerId) {
		this.retailerId = retailerId;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", price=" + price + ", colour=" + colour + ", dimensions=" + dimensions
				+ ", specifications=" + specifications + ", manufacture=" + manufacture + ", quantity=" + quantity
				+ ", productCategory=" + productCategory + ", productName=" + productName + ", retailerId=" + retailerId
				+ "]";
	}
	
	
	
	
	

 

}
