package com.cbp.in.service;

import java.util.List;

import com.cbp.in.entity.Transaction;

public interface TransactionService {
	
	public Transaction addTransaction(Transaction transaction);
	
	public String removeTransaction(long id);
	
	public Transaction updateTransaction(long id,Transaction transaction);
	
	public Transaction getTransactionDetails(long id);
	
	public List<Transaction> getAllTransactions();

}
