package com.cbp.in.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbp.in.entity.Transaction;
import com.cbp.in.service.TransactionService;
@RestController
@RequestMapping("/transactionapi")
public class TransactionController {
	
		@Autowired
		TransactionService transactionService;
		
		@PostMapping("/addtransaction")
		public Transaction addTransaction(@Valid @RequestBody Transaction transaction)
		{
			return transactionService.addTransaction(transaction);
		}
		@GetMapping("/removetransaction/{id}")
		public String removeTransaction(@PathVariable("id")Long id) 
		{
			return transactionService.removeTransaction(id);
		}
		@PostMapping("/updatetransaction/{id}")
		public Transaction updateTransaction(@PathVariable("id")int id,@RequestBody Transaction transaction)
		{
			return transactionService.updateTransaction(id, transaction);
		}
		@GetMapping("/gettransactiondetails/{id}")
		public Transaction getTransactionDetails(@PathVariable("id")int id)
		{
			return transactionService.getTransactionDetails(id);
		}
		@GetMapping("/getalltransactions")
		public List<Transaction> getAllTransactions()
		{
			return transactionService.getAllTransactions();
		}

}
