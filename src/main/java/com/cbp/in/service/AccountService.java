package com.cbp.in.service;

import java.util.List;

import com.cbp.in.entity.Account;

public interface AccountService {
		
	public Account addAccount(Account account);
	
	public Account removeAccount(long id);
	
	public Account updateAccount(long id, Account account);
	
	public Account getAccount(long id);
	
	public List<Account> getAllAccounts();

}
