package com.mozzishop.www.user.service;

import org.springframework.stereotype.Service;

import com.mozzishop.www.user.jpa.User;

@Service
public interface UserService {
	
	User FindByEmail(String email) throws Exception;
}
