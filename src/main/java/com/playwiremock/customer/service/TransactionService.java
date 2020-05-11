package com.playwiremock.customer.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playwiremock.customer.model.Transaction;
import com.playwiremock.customer.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	public List<Transaction> getAllTransactions() {
		return transactionRepository.findAll();
	}

	public void addOrUpdateTransaction(Transaction transactionDto) {
		UUID transactionID = transactionDto.getId();
		transactionDto.setId(transactionID);
		transactionDto.getCreditor().setTransaction(transactionDto);
		transactionDto.getDebtor().setTransaction(transactionDto);
		transactionDto.getExchangeRate().setTransaction(transactionDto);
		transactionDto.getOriginalAmount().setTransaction(transactionDto);
		
		transactionRepository.save(transactionDto);
	}

}
