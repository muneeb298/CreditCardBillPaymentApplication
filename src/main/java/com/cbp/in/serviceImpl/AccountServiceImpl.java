package com.cbp.in.serviceImpl;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbp.in.entity.Account;
import com.cbp.in.exceptions.AccountNotFoundException;
import com.cbp.in.repository.AccountRepository;
import com.cbp.in.service.AccountService;

 
@Service
public class AccountServiceImpl implements AccountService {
 
	@Autowired
	AccountRepository accountrepository;

 
	Account acc;
 
	@Override
	public Account addAccount(Account account) {
 
		accountrepository.saveAndFlush(account);
		
		return account;
 
	}
 
	@Override
	public Account removeAccount(long id) {
		if (accountrepository.existsById(id)) {
			Account a = accountrepository.findById(id).get();
			accountrepository.deleteById(id);
		System.out.println("Account removed successfully");
		return a;
		}
		else {
			throw new AccountNotFoundException("Account not found");
		}
	}
 
	@Override
	public Account updateAccount(long id, Account account) {
		if (accountrepository.existsById(account.getAccountId())) {
			Account acc = accountrepository.findById(account.getAccountId()).get();
			acc.setAccountName(account.getAccountName());
			acc.setBalance(account.getBalance());
			acc.setAccountType(account.getAccountType());
 
			accountrepository.save(acc);
 
			return acc;
		} else {
 
			throw new AccountNotFoundException("Account not found");
		}
 
	}
 
	@Override
	public Account getAccount(long id) {
		if (accountrepository.existsById(id)) {
			return accountrepository.findById(id).get();
		} else {
			throw new AccountNotFoundException("Account not found");
		}
	}
 
	@Override
	public List<Account> getAllAccounts() {
		System.out.println("getall accounts");
		return accountrepository.findAll();
	}
 
}