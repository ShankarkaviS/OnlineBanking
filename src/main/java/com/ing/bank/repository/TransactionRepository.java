package com.ing.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ing.bank.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {

}
