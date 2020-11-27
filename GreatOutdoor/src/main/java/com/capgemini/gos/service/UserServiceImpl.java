package com.capgemini.gos.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.gos.dao.UserDao;
import com.capgemini.gos.entity.Userdata;
import com.capgemini.gos.exceptions.IdNotFoundException;

@Service
@Transactional
public class UserServiceImpl implements UserService 
{
@Autowired
UserDao dao;

@Override
public Userdata addUser(Userdata u) {
	return dao.save(u);
}

@Override
public List<Userdata> getAllUsers() 
{
return dao.findAll();
}

@Override
public Userdata getuserbyid(int userId) {
	Optional<Userdata> a = dao.findById(userId);
	if (a.isPresent()) 
		 return a.get();
	else
		throw new IdNotFoundException("user does not exists");
}

@Override
public void deleteUser(int userId) 
{
	 dao.deleteById(userId);
}

@Override
public Userdata updateUser(Userdata u) {
	boolean value=dao.existsById(u.getUserId());
	if(value)
	{
		
		u.setUserPassword(u.getUserPassword());
		u.setUserPhoneno(u.getUserPhoneno());
		u.setUserEmail(u.getUserEmail());
	}
	dao.save(u);
	return u;	
}

@Override
public Boolean loginUser(Userdata u)
{
    Optional <Userdata> ud=dao.findById(u.getUserId());
	if(!ud.isPresent())
	{
		throw new IdNotFoundException("User does not exists");
	}
	if(!ud.get().getUserPassword().equals(u.getUserPassword())){
		throw new IdNotFoundException("Password mismatch");
	}
	return true;
	
}
}