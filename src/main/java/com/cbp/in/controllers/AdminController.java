package com.cbp.in.controllers;
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cbp.in.entity.Admin;
import com.cbp.in.service.AdminService;
 

 
 
@RestController
 
public class AdminController {
	@Autowired
	AdminService adminservice;
	@PostMapping("/addadmin")
	public  String addAdmin(@Valid @RequestBody Admin admin)
	{
		return adminservice.addAdmin(admin);
	}

 
}
