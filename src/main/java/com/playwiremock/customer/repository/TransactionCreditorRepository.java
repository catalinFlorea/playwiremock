package com.playwiremock.customer.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.playwiremock.customer.model.TransactionCreditor;

public interface TransactionCreditorRepository extends JpaRepository<TransactionCreditor, UUID> {

}
