package com.mozzishop.www.user.service;

import com.mozzishop.www.user.jpa.Grade;
import com.mozzishop.www.user.jpa.User;

public interface UserService {
	
	User findByPrincipal(String principle);

	User findByEmail(String email);
	
	void ChangeGrade(Grade grade, long idx);

}
