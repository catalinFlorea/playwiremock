package com.playwiremock.customer.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.playwiremock.customer.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

}
