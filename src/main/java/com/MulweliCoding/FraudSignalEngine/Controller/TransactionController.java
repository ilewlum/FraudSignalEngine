package com.MulweliCoding.FraudSignalEngine.Controller;

import java.lang.reflect.Array;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.MulweliCoding.FraudSignalEngine.Model.Transaction;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.*;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    //in-memory list to store transactions
    private List<Transaction> transactions = new ArrayList<>();

    public TransactionController() {
        // Initialize with some sample data
        transactions.add(new Transaction(1, 100.0, "2024-10-01T10:00:00Z", "New York"));
        transactions.add(new Transaction(2, 250.5, "2024-10-01T11:30:00Z", "Los Angeles"));
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    // Get all Transactions
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactions;
    }

    // Get Transaction by ID
    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable long id) {
        for (Transaction transaction : transactions) {
            if (transaction.getTransactionId() == id) {
                return transaction;
            }
        }
        System.out.println("Transaction not found for ID: " + id);
        return null; 
    }

    // Create a new Transaction
    @PostMapping("/create")
    public void createTransaction(@RequestBody TransactionDTO transactionDTO) {
        Transaction newTransaction = new Transaction(
            transactionDTO.getUserId(),
            transactionDTO.getAmount(),
            transactionDTO.getTimestamp(),
            transactionDTO.getLocation()
        );
        transactions.add(newTransaction);
    }

    @PutMapping("/update/{id}")
    public void updateTransaction(@PathVariable long id, @RequestBody TransactionDTO transactionDTO) {
        for (Transaction transaction : transactions) {
            if (transaction.getTransactionId() == id) {
                transaction.setUserId(transactionDTO.getUserId());
                transaction.setAmount(transactionDTO.getAmount());
                transaction.setTimestamp(transactionDTO.getTimestamp());
                transaction.setLocation(transactionDTO.getLocation());
                return;
            }
        }
        System.out.println("Transaction not found for ID: " + id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTransaction(@PathVariable long id) {
        transactions.removeIf(transaction -> transaction.getTransactionId() == id);
    }
}
