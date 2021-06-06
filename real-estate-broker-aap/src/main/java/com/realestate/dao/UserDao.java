package com.realestate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.realestate.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

	public User findByUserEmail(String userEmail);
	
}
