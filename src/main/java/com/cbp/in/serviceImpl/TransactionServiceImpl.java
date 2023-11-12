package com.cbp.in.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbp.in.entity.Transaction;
import com.cbp.in.exceptions.TransactionNotFoundException;
import com.cbp.in.repository.TransactionRepository;
import com.cbp.in.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public Transaction addTransaction(Transaction transaction) {
		transactionRepository.saveAndFlush(transaction);
		return transaction;
	}

	@Override
	public String removeTransaction(long id) {
		if (transactionRepository.existsById(id)) {
			Transaction t = transactionRepository.findById(id).get();
			transactionRepository.deleteById(id);
			return "transaction Removed";
		} else {
			throw new TransactionNotFoundException("Transaction not found ");
		}
	}

	@Override
	public Transaction updateTransaction(long id, Transaction transaction) {
		if (!transactionRepository.existsById(id)) {
			throw new TransactionNotFoundException("Transaction not found ");
		} else {
			Transaction t = transactionRepository.findById(id).get();

			return transactionRepository.save(transaction);

		}
	}

	@Override
	public Transaction getTransactionDetails(long id) {
		if (!transactionRepository.existsById(id)) {
			throw new TransactionNotFoundException("Transaction not found ");
		} else {

			return transactionRepository.findById(id).get();
		}
	}

	@Override
	public List<Transaction> getAllTransactions() {

		return transactionRepository.findAll();
	}

}
