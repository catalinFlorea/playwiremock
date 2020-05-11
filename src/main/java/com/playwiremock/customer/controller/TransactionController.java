package com.playwiremock.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.playwiremock.customer.model.Transaction;
import com.playwiremock.customer.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	@Autowired
	private TransactionService transactionService;

	@GetMapping(path = "/v1/getAllTransactions")
	public ResponseEntity<List<Transaction>> getAllTransactions() {
		List<Transaction> transactionsList = transactionService.getAllTransactions();
		return new ResponseEntity<>(transactionsList, HttpStatus.OK);
	}
}
