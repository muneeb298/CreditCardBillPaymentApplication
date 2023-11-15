package com.cbp.in.serviceTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.cbp.in.entity.Account;
import com.cbp.in.exceptions.AccountNotFoundException;
import com.cbp.in.repository.AccountRepository;
import com.cbp.in.service.AccountService;
import com.cbp.in.serviceImpl.AccountServiceImpl;



public class AccountServiceTest {

	private AccountService accountService;
	private AccountRepository accountRepository;

	@Test
	@BeforeEach
	void setUp() {
		
		accountRepository = mock(AccountRepository.class);
		accountService = new AccountServiceImpl(accountRepository);
	}

	@Test
	@DisplayName("Test adding an account")
	void testAddAccount() {
		
		Account account = new Account(1L, "rohit", 2713.0, "savings");

		
		when(accountRepository.saveAndFlush(account)).thenReturn(account);

		Account savedAccount = accountService.addAccount(account);

		assertEquals(account, savedAccount);
		verify(accountRepository, times(1)).saveAndFlush(account);
	}

	@Test
	@DisplayName("Test removing an account not found")
	void testRemoveAccountNotFound() {
		
		long accountId = 1L;

		when(accountRepository.existsById(accountId)).thenReturn(false);

		assertThrows(AccountNotFoundException.class, () -> accountService.removeAccount(accountId));
		verify(accountRepository, never()).deleteById(anyLong());
	}

}