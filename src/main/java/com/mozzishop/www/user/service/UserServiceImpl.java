package com.mozzishop.www.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mozzishop.www.user.jpa.Grade;
import com.mozzishop.www.user.jpa.User;
import com.mozzishop.www.user.jpa.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void upgradeUserToCreator(User user) {
		// TODO Auto-generated method stub
		user.builder()
			.grade(Grade.CREATOR);
		userRepository.save(user);
		
	}

	@Override
	public void upgradeUserToAdmin(User user) {
		// TODO Auto-generated method stub
		user.builder()
		.grade(Grade.ADMIN);
		userRepository.save(user);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}



}
