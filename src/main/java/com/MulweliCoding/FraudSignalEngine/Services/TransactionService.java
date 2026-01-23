package com.MulweliCoding.FraudSignalEngine.Services;

import com.MulweliCoding.FraudSignalEngine.Repository.TransactionRepository;
import com.MulweliCoding.FraudSignalEngine.Model.Transaction;
import java.util.List;

public class TransactionService {
    private TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void createTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public List<Transaction> getTransactionsByUserId(long userId) {
        return transactionRepository.findByUserId(userId);
    }

    public List<Transaction> getTransactionsByAmount(double amount) {
        return transactionRepository.findByAmount(amount);
    }

    public List<Transaction> getTransactionsByLocation(String location) {
        return transactionRepository.findByLocation(location);
    }

    public List<Transaction> getTransactionsByTimestamp(String timestamp) {
        return transactionRepository.findByTimestamp(timestamp);
    }


}
