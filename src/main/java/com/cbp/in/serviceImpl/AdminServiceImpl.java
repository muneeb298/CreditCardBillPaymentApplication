package com.cbp.in.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbp.in.entity.Admin;
import com.cbp.in.repository.AdminRepository;
import com.cbp.in.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminRepository adminrepository;
	
	public String addAdmin(Admin admin) {
		
		String p = "^(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[A-Z])(?=.*[a-z]).{8,}$";
		
		if(admin.getUser().getPassword().matches(p)) {
			
			adminrepository.save(admin);
			
			return "admin added sucessfully";
		}
		else {
			
			return "Password not according to rules";
		}	
	}


}
