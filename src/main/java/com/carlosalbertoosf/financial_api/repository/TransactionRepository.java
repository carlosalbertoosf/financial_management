package com.carlosalbertoosf.financial_api.repository;

import com.carlosalbertoosf.financial_api.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
