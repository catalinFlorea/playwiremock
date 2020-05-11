package com.playwiremock.customer.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.playwiremock.customer.model.TransactionDebtor;

public interface TransactionDebtorRepository extends JpaRepository<TransactionDebtor, UUID> {

}
