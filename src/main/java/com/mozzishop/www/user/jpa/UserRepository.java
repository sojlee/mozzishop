package com.mozzishop.www.user.jpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	
	User findByEmail(String email);

	User findByPincipal(String pincipal);
	
	List<User> findAllByGrade(Grade grade);
	
	User findByGrade(Grade grade);
	
	@Modifying
	@Transactional
	@Query("UPDATE User SET grade = :grade WHERE idx = :idx")
	void MakeAdmin(Grade grade, long idx);

}
