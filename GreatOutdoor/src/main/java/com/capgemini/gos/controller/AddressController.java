package com.capgemini.gos.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.gos.entity.Address;
import com.capgemini.gos.exceptions.AddressNotFound;
import com.capgemini.gos.service.AddressService;

@RestController
@RequestMapping("/address")
@CrossOrigin("http://localhost:4200")
public class AddressController {
	@Autowired
	private AddressService service;

	// maps to add address method in service layer 
	 @PostMapping(value="/addaddress")
	    public ResponseEntity<String> addAddress(@RequestBody Address adrs)
	    {
	   	 Address  a= service.addAddress(adrs);
	   		if (a == null) {
	   			throw new AddressNotFound("Invalid Address details");
	   		} else {
	   			return new ResponseEntity<>("Address details are added successfully", new HttpHeaders(), HttpStatus.OK);
	   		}
	    }
	 
	// maps to delete address method in service layer 
	@DeleteMapping("/deleteaddress/{addressId}")
	public String deleteAddress(@PathVariable("addressId") int addressId)
	{
		service.deleteAddress(addressId);
		return "address removed successfully";
	}
	
	// maps to update address method in service layer 
	@PutMapping("/updateAddress")
	public String updateAddress(@RequestBody Address address)
	{
		return service.updateAddress(address);
	}
	
	// maps to get all address method in service layer 
	@GetMapping(value="/getAllAddress",produces="application/json")
	public List <Address> viewAddress()
	{
		return service.viewAddress();	
	}
	
	
	@GetMapping(value="/getaddress/{addressId}",produces="application/json")
	public Address viewAddress(@PathVariable int addressId)
	
	{
	return service.viewAddress(addressId);	
	}
}




