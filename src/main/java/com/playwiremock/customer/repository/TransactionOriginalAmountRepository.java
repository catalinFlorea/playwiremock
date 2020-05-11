package com.playwiremock.customer.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.playwiremock.customer.model.TransactionOriginalAmount;

public interface TransactionOriginalAmountRepository extends JpaRepository<TransactionOriginalAmount, UUID> {

}
