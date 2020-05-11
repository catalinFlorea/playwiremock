package com.playwiremock.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.playwiremock.customer.model.Account;
import com.playwiremock.customer.service.AccountService;
import com.playwiremock.customer.webclient.ScheduledWebClientCaller;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private ScheduledWebClientCaller webCaller;

	@GetMapping(path = "/v1/getAllAccounts")
	public ResponseEntity<List<Account>> getAllAccounts() {
		List<Account> accountList = accountService.getAllAccounts();
		return new ResponseEntity<>(accountList, HttpStatus.OK);
	}

	@GetMapping(path = "/v1/getAccountsForUser")
	public ResponseEntity<List<Account>> getAllAccounts(@RequestParam("username") String username) {
		List<Account> accountList = accountService.getAllAccounts("Account-" + username);
		return new ResponseEntity<>(accountList, HttpStatus.OK);
	}

	@PostMapping(path = "/v1/syncAccounts")
	public void account() {
		webCaller.scheduledCallAccountsAPI();
	}

}
