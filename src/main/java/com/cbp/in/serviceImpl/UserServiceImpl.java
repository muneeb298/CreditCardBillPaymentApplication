package com.cbp.in.serviceImpl;

import java.util.List;

import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbp.in.entity.User;
import com.cbp.in.exceptions.PasswordNotFoundException;
import com.cbp.in.exceptions.UserIdNotFoundException;
import com.cbp.in.repository.UserRepository;
import com.cbp.in.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	 private User loggedInUser;

//	public String register(User user) {
//		
//		if (loggedInUser == null) {
//
//			String passwordregex = "^(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[A-Z])(?=.*[a-z]).{8,}$";
//			
//			if (user.getPassword().matches(passwordregex)) {
//				
//				userRepository.saveAndFlush(user);
//				
//				return "New User Added Successfully";
//				
//			} else
//				
//				return "Password not according to rules";
//			
//		} else {
//			
//			return "Try Registering after signing out";
//		}
//	}
  
	 @Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}
	

	@Override
	public String signIn(User user) {
		
		if (loggedInUser == null) {
			
			if (userRepository.existsById(user.getUserId())) {
				
				User uuser = userRepository.findById(user.getUserId()).get();
				
				String cpass = uuser.getPassword();
				
				if ((user.getPassword()).equals(cpass)) {
					
					loggedInUser = uuser;
					
					return "Welcome! You have successfully signed in.";
					
				} else {
					
					throw new PasswordNotFoundException("Password is wrong");
				}
			} else {
				
				throw new UserIdNotFoundException("This UserId doesn't exists");
			}
		} else {
			
			return "you have already signned in";
		}
	}

	@Override
	public String signOut(User user) {
		
		if(userRepository.existsById(user.getUserId())) {
			
			if (loggedInUser != null) {
				
				if (loggedInUser.getUserId() == (user.getUserId()) && loggedInUser.getPassword().equals(user.getPassword())) {
					
					loggedInUser = null;
					
					return "you have sucessfully logged out";
					
				} else {
					
					return "incorrect username or password";
				}
			} else {
				
				return "you are not siggned in please SignIn first";
			}
		}
		else {
			
			throw new UserIdNotFoundException("This UserId doesn't exists");
		}
	}

	@Override
	public String changePassword(User user) {

		if (userRepository.existsById(user.getUserId())) {

			User olduser = userRepository.findById(user.getUserId()).get();

			if (olduser.getPassword().equals(user.getPassword())) {

				return "Give Different password";
			} else {

				String passwordregex = "^(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[A-Z])(?=.*[a-z]).{8,}$";

				if (user.getPassword().matches(passwordregex)) {

					userRepository.save(user);

					return "Password changed";
				} else {

					return "Password not according to rules";
				}
			}
		} else {

			throw new UserIdNotFoundException("This UserId doesn't exists");
		}
	}
}