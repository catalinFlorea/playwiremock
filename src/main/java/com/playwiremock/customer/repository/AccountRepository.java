package com.playwiremock.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.playwiremock.customer.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
