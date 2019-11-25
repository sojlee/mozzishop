package com.mozzishop.www.user.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mozzishop.www.user.jpa.User;
import com.mozzishop.www.user.jpa.UserRepository;

public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository ur;

	@Override
	public User FindByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		return ur.findByEmail(email);
	}

}
