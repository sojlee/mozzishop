package com.mozzishop.www.user.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>{
	
	List<User> findByEmail();

}
