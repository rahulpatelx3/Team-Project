package com.realestate.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.realestate.entity.User;
import com.realestate.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Optional<User>> getUser(@PathVariable("id") int id) {
		Optional<User> optional= this.userService.getUser(id);
		if(optional==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(optional));
	}
	
	
	@GetMapping("/get/")
	public ResponseEntity<List<User>> getAllUser(Model m) {
		List<User> list = this.userService.getAllUsers();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		m.addAttribute("hello","Rahul patel");
		return ResponseEntity.of(Optional.of(list));
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<User> setUser(@RequestBody User u) {
		User user=null;
		try {
			user=this.userService.setUser(u);
			ResponseEntity.status(HttpStatus.CREATED).build();
			return ResponseEntity.of(Optional.of(user));
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	@PutMapping("/update/{id}")
	public User updateUser(@RequestBody User u,@PathVariable("id") int id) {
		User user=new User();                                                     // will connect with frontend
		user.setUserId(id);
		user.setUserName("Rahul Patel");
		user.setUserEmail("rahulpatelx3@gmail.com");
		user.setUserPassword("password");
		user.setUserCity("Narsinghpur");
		user.setUserState("Madhya Pradesh");
		return this.userService.updateUser(user, id);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteUser(@RequestBody User user,@PathVariable("id") int id){
		try {
			this.userService.deleteUser(id);
			return ResponseEntity.ok().build();
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
