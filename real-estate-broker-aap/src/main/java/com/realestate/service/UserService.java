package com.realestate.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.realestate.dao.UserDao;
import com.realestate.entity.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	public Optional<User> getUser(int id) {
		Optional<User> user=null;
		try {
			user=this.userDao.findById(id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	public List<User> getAllUsers(){
		return this.userDao.findAll();
	}
	public User setUser(User u) {
		return this.userDao.save(u);
	}
	public User findUserByEmail(String UserEmail)
	{
		User user=userDao.findByUserEmail(UserEmail);
		return user;
	}
	public void deleteUser(int id){
		this.userDao.deleteById(id);
	}
	public User updateUser(User u,int id) {
		Optional<User> optional=this.userDao.findById(id);
		User user=optional.get();
		u.setUserName(user.getUserName());
		u.setUserEmail(user.getUserEmail());
		u.setUserPassword(user.getUserPassword());
		u.setUserCity(user.getUserCity());
		u.setUserState(user.getUserState());
		return u;
	}
}
