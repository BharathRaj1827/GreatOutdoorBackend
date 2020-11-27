package com.capgemini.gos.service;


import java.util.List;

import com.capgemini.gos.entity.Address;

public interface AddressService {

	Address addAddress(Address adrs);
	 String updateAddress(Address adrs);
	  void deleteAddress(int addressId);
	List<Address> viewAddress();
	Address viewAddress(int addressId);

}
