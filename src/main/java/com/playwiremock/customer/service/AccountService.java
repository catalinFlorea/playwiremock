package com.playwiremock.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playwiremock.customer.model.Account;
import com.playwiremock.customer.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}
	
	public List<Account> getAllAccounts(String name) {
		return accountRepository.findByName(name);
	}

	public void addOrUpdateAccount(Account accountDto) {
		Account account = accountDto;
		account.setId(accountDto.getId());
		accountRepository.save(account);
	}
}
