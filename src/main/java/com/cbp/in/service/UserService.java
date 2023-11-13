package com.cbp.in.service;

import java.util.List;

import com.cbp.in.entity.Users;

public interface UserService {
	public String signIn(Users user);
	public String signOut(Users user);
	public String changePassword(Users user);
	public List<Users> getAllUsers();

}
