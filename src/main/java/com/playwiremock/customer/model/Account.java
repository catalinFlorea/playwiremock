package com.playwiremock.customer.model;

import java.time.OffsetDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
	private UUID id;

	private OffsetDateTime update;

	private String name;

	private String product;

	private AccountStatus status;

	private AccountType type;

	private float balance;

	public Account() {
	}

	public Account(UUID id, OffsetDateTime update, String name, String product, AccountStatus status, AccountType type,
			float balance) {
		this.id = id;
		this.update = update;
		this.name = name;
		this.product = product;
		this.status = status;
		this.type = type;
		this.balance = balance;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public OffsetDateTime getUpdate() {
		return update;
	}

	public void setUpdate(OffsetDateTime update) {
		this.update = update;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

}
