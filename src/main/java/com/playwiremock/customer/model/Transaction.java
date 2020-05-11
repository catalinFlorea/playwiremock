package com.playwiremock.customer.model;

import java.time.OffsetDateTime;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class Transaction {

	@Id
	private UUID id;

	@ManyToOne(fetch = FetchType.LAZY)
	private Account account;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "transaction")
	private TransactionExchangeRate exchangeRate;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "transaction")
	private TransactionOriginalAmount originalAmount;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "transaction")
	private TransactionCreditor creditor;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "transaction")
	private TransactionDebtor debtor;

	private String status;
	private String currency;
	private float amount;
	private OffsetDateTime update;
	private String description;

	public Transaction() {
	}

	public UUID getId() {
		return id;

	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public TransactionExchangeRate getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(TransactionExchangeRate exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public TransactionOriginalAmount getOriginalAmount() {
		return originalAmount;
	}

	public void setOriginalAmount(TransactionOriginalAmount originalAmount) {
		this.originalAmount = originalAmount;
	}

	public TransactionCreditor getCreditor() {
		return creditor;
	}

	public void setCreditor(TransactionCreditor creditor) {
		this.creditor = creditor;
	}

	public TransactionDebtor getDebtor() {
		return debtor;
	}

	public void setDebtor(TransactionDebtor debtor) {
		this.debtor = debtor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public OffsetDateTime getUpdate() {
		return update;
	}

	public void setUpdate(OffsetDateTime update) {
		this.update = update;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}