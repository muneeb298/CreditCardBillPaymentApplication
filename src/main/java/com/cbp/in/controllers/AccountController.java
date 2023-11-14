package com.cbp.in.controllers;
import java.util.List;
 
 
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbp.in.entity.Account;
import com.cbp.in.service.AccountService;
 
 
@RestController
@RequestMapping("/accountapi")
public class AccountController {
 
	@Autowired
	private AccountService accountservice;
	
	@PostMapping("/addaccount")
	public Account addAccount(@Valid @RequestBody Account account) 
	{
		return accountservice.addAccount(account);
	}
	
	@GetMapping("/removeaccount/{id}")
	public Account removeAccount(@PathVariable("id") long id) {
		return accountservice.removeAccount(id);
    }
	
	@GetMapping("/getaccount/{id}")
	public Account getAccount(@PathVariable("id") long id) {
		return accountservice.getAccount(id);
	}
	
	@GetMapping("/getallaccounts")
	public List<Account> getAllAccounts(){
		return accountservice.getAllAccounts();
	}
	
	@PutMapping("/updateaccount/{id}")
	public Account updateAccount(@PathVariable("id")int id,@RequestBody Account account){
		return accountservice.updateAccount(id,account);
		}
}