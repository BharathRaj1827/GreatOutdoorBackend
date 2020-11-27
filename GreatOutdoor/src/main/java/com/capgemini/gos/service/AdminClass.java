package com.capgemini.gos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.gos.dao.AdminDao;
import com.capgemini.gos.entity.Admins;

@Service
@Transactional
public class AdminClass implements AdminInterface {

	@Autowired
	private AdminDao admindao;

	@Override
	public Admins validate(String aname, String apwd) {
		return admindao.validate(aname, apwd);
	}
}