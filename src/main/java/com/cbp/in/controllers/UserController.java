package com.cbp.in.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbp.in.entity.User;
import com.cbp.in.service.UserService;



@RestController
@RequestMapping("/loginapi")
public class UserController {
	
	@Autowired
	private UserService userService;

//	@PostMapping("/addUser")
//	public String add(@Valid @RequestBody Users user) {
//		return userService.register(user);
//	}

	@GetMapping("/getallusers")
	public List<User> getAll() {
		return userService.getAllUsers();
	}
	@PostMapping("/signin")
	public String signIn(@Valid @RequestBody User user) {
		return userService.signIn(user);
	}
	@PostMapping("/signout")
	public String signOut(@Valid @RequestBody User user) {
		return userService.signOut(user);
	}
	@PutMapping("/changepassword")
	public String changePassword(@Valid @RequestBody User user) {
		return userService.changePassword(user);
	}
}
