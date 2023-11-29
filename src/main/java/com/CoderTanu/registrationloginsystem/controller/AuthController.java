package com.CoderTanu.registrationloginsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.CoderTanu.registrationloginsystem.dto.UserDto;
import com.CoderTanu.registrationloginsystem.serviceImpl.UserServiceimpl;

@Controller
public class AuthController {
	
	private UserServiceimpl userServiceimpl;
	
	
	
	public AuthController(UserServiceimpl userServiceimpl) {
		this.userServiceimpl = userServiceimpl;
	}

	//method To handle home page request
	@GetMapping("/index")
	public String home() {
		return "index";
	}
	
	// method handle login request
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	//method to handle the user registeration 
	@GetMapping("/register")
	public String  registerUser(Model model){
		//create model object to stord form data
		UserDto user = new UserDto();
		model.addAttribute("user", user);
		return "register";
		
	}
	
	//method to handle user registerion submition form
	@PostMapping("/register/save")
	public String registeration(@ModelAttribute("user") UserDto userdto) {
		userServiceimpl.saveUser(userdto);
		
		return "redirect:/register?success";
	}

}
