package com.realestate.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.realestate.entity.User;
import com.realestate.service.UserService;

@Controller
public class HomeController {
	@Autowired
	private UserService userservice;
	User user=new User();
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}
	@PostMapping(path="/login")
	public String Login(@RequestParam("email") String email,@RequestParam("password") String password) {
		User u=userservice.findUserByEmail(email);
		if(u.getUserEmail().equals(email) && u.getUserPassword().equals(password))
		{
			System.out.println("User Credentials Matched");
			return "userDashboard";
		}
		else if(email.equals("admin@xyz.com") && password.equals("123"))
		{
			System.out.println("User Credentials Matched");
			return "adminDashboard";
		}
		else {
			System.out.println("User Credentials not Matched");
			return "login";
		}
	}
	
	@RequestMapping("/userDashboard")
	public String userDashboard() {
		return "userDashboard";
	}
	
	@RequestMapping("/registration")
	public String registerPage() {
		return "registration";
	}
	@PostMapping("/registration")
	public String Register(@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("city") String city,
			@RequestParam("state") String state,Model m) {
		User user=new User();
		user.setUserName(name);
		user.setUserEmail(email);
		user.setUserPassword(password);
		user.setUserCity(city);
		user.setUserState(state);
		userservice.setUser(user);
		m.addAttribute("user", user);
		System.out.println("Registered Successfully");
		return "login";
	}
	@RequestMapping("/forgetPassword")
	public String forgetPasswordPage() {
		return "forgetPassword";
	}
	@PostMapping("/forgetPassword")
	public String forgetPassword(@RequestParam("email") String email,
			@RequestParam("password") String password,Model m) {
		User u=userservice.findUserByEmail(email);
		if(u.getUserEmail().equals(email)) {
			u.setUserPassword(password);
			System.out.println("Password Reset Successfully");
			m.addAttribute("user", u);
			return "login";
		}
		else {
			System.out.println("Password Not Reseted Successfully");
		return "forgetPassword";
		}
	}
}
