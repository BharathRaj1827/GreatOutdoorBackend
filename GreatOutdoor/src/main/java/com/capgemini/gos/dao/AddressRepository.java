package com.capgemini.gos.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.gos.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
	
	

}