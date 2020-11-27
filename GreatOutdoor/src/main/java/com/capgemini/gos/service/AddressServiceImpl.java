package com.capgemini.gos.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import com.capgemini.gos.dao.AddressRepository;
import com.capgemini.gos.entity.Address;
import com.capgemini.gos.exceptions.AddressNotFound;


@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository repository;


public List<Address> viewAddress() {
		return repository.findAll();
	}

	public Address viewAddress(int addressId) {
		return repository.findById(addressId).get();
		
	}

	/*public Address updateAddress(Address adrs) {
		Address a= repository.findById(adrs.getAddressId()).get();
		if(a!=null)
		{
			a.setAddressId(adrs.getAddressId());
			a.setBuildingNo(adrs.getBuildingNo());
			a.setCity(adrs.getCity());
			a.setPincode(adrs.getPincode());
			a.setState(adrs.getState());
			a.setUserId(adrs.getUserId());
		}
		return repository.save(a);
		}
*/
	
	public String updateAddress(Address adrs) {
		if(repository.existsById(adrs.getAddressId()))
		{
			repository.save(adrs);
			return "address is updated";	
		}
		else{
			return "sorry,address was not updated";
		}
}

	public void deleteAddress(int addressId) {
		
		repository.deleteById(addressId);;
	}

	public Address addAddress(Address adrs) {
		return repository.save(adrs);
	}
}