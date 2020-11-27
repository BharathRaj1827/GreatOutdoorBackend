package com.capgemini.gos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="retailer_address")
public class Address {
@Id
@Column(name="addressId")
private int addressId;

@Column(name="userId")
private int userId;

@Column(name="buildingNo")
private int buildingNo;

@Column(name="city")
private String city;

@Column(name="state")
private String state;

@Column(name="pincode")
private int pincode;


public Address() {
	super();

}


public Address( int addressId, int userId, int buildingNo, String city, String state, int pincode) {
	super();
	this.addressId = addressId;
	this.userId = userId;
	this.buildingNo = buildingNo;
	this.city = city;
	this.state = state;
	this.pincode = pincode;
}


public int getAddressId() {
	return addressId;
}


public void setAddressId(int addressId) {
	this.addressId = addressId;
}


public int getUserId() {
	return userId;
}


public void setUserId(int userId) {
	this.userId = userId;
}


public int getBuildingNo() {
	return buildingNo;
}


public void setBuildingNo(int buildingNo) {
	this.buildingNo = buildingNo;
}


public String getCity() {
	return city;
}


public void setCity(String city) {
	this.city = city;
}


public String getState() {
	return state;
}


public void setState(String state) {
	this.state = state;
}


public int getPincode() {
	return pincode;
}


public void setPincode(int pincode) {
	this.pincode = pincode;
}


@Override
public String toString() {
	return "Address [addressId=" + addressId + ", userId=" + userId + ", buildingNo=" + buildingNo + ", city=" + city
			+ ", state=" + state + ", pincode=" + pincode + "]";
}

}