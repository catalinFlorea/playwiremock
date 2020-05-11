package com.playwiremock.customer.webclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.playwiremock.customer.model.Account;
import com.playwiremock.customer.model.Transaction;
import com.playwiremock.customer.service.AccountService;
import com.playwiremock.customer.service.TransactionService;

import reactor.core.publisher.Flux;

@Controller
public class ScheduledWebClientCaller {
	private static final Logger logger = LoggerFactory.getLogger(ScheduledWebClientCaller.class);

	@Autowired
	private AccountService accountService;

	@Autowired
	private TransactionService transactionService;

	/**
	 * Scheduled call of Accounts API on every day at 2 AM
	 */

	@Scheduled(cron = "0 0 2 * * *")
	public void scheduledCallAccountsAPI() {
		logger.info("Calling schedule accounts API started");
		String authorizationToken = ProviderWebClient.getAuthToken("Gigi").getToken();

		Flux<Account> responseAccounts = ProviderWebClient.builder().get().uri("/accounts")
				.header("X-AUTH", authorizationToken).retrieve().bodyToFlux(Account.class);
		responseAccounts.subscribe(this::handleAccountWebServiceResponse);
	}

	/**
	 * Scheduled call of Transaction API on every day at 2 AM
	 */
	@Scheduled(cron = "0 0 3 * * ?")
	public void scheduledCallTransactionsAPI() {
		logger.info("Calling schedule transactions API started");
		String authorizationToken = ProviderWebClient.getAuthToken("Gigi").getToken();

		Flux<Transaction> responseTransactions = ProviderWebClient.builder().get().uri("/transactions")
				.header("X-AUTH", authorizationToken).retrieve().bodyToFlux(Transaction.class);
		responseTransactions.subscribe(this::handleTransactionsWebServiceResponse);
	}

	private void handleAccountWebServiceResponse(Account accountDTO) {
		accountService.addOrUpdateAccount(accountDTO);
	}

	private void handleTransactionsWebServiceResponse(Transaction transactionDTO) {
		transactionService.addOrUpdateTransaction(transactionDTO);
	}

}
