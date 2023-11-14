package com.cbp.in.service;

import java.util.List;

import com.cbp.in.entity.User;

public interface UserService {
	
	//public String register(Users user);
	public String signIn(User user);
	public String signOut(User user);
	public String changePassword(User user);
	public List<User> getAllUsers();

}
