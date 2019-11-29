package com.mozzishop.www.user.service;

import org.springframework.stereotype.Service;

import com.mozzishop.www.user.jpa.User;

public interface UserService {
	
	void upgradeUserToCreator(User user);

	void upgradeUserToAdmin(User user);

	User findByEmail(String email);

}
