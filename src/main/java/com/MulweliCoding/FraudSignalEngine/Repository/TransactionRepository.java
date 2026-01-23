package com.MulweliCoding.FraudSignalEngine.Repository;

import com.MulweliCoding.FraudSignalEngine.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    public List<Transaction> findByUserId(long userId);
    public List<Transaction> findByAmount(double amount);
    public List<Transaction> findByLocation(String location);
    public List<Transaction> findByTimestamp(String timestamp);
}
