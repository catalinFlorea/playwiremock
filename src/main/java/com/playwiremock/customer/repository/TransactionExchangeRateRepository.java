package com.playwiremock.customer.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.playwiremock.customer.model.TransactionExchangeRate;

public interface TransactionExchangeRateRepository extends JpaRepository<TransactionExchangeRate, UUID>{

}
