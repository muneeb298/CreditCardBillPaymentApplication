package com.cbp.in.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbp.in.entity.Users;
import com.cbp.in.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/loginapi")
public class UserController {
	@Autowired
	private UserService userService;
	public UserController() {}
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/getallusers")
	public List<Users> getAll() {
		return userService.getAllUsers();
	}
	@PostMapping("/signin")
	public String signIn(@Valid @RequestBody Users user) {
		return userService.signIn(user);
	}
	@PostMapping("/signout")
	public String signOut(@RequestBody Users user) {
		return userService.signOut(user);
	}
	@PutMapping("/changepassword")
	public String changePassword(@RequestBody Users user) {
		return userService.changePassword(user);
	}
}
