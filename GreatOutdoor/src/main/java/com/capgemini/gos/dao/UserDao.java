package com.capgemini.gos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.gos.entity.Userdata;


@Repository
public interface UserDao extends JpaRepository<Userdata, Integer> {
	
	
}
