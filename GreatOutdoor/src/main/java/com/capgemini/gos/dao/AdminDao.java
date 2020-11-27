package com.capgemini.gos.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.gos.entity.Admins;


public interface AdminDao extends JpaRepository<Admins,Integer>
{	
	@Query("select a from Admins a where a.adminname=?1 and a.adminpassword=?2 ")
	Admins validate(String aname, String apwd);

}
