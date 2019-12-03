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
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	public User findByPrincipal(String principle) {
		// TODO Auto-generated method stub
		return userRepository.findByPrincipal(principle);
	}

	@Override
	public void ChangeGrade(Grade grade, long idx) {
		// TODO Auto-generated method stub
		userRepository.ChangeGrade(grade, idx);
	}

	@Override
	public void SaveUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}



}
