package com.MulweliCoding.FraudSignalEngine.Services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.MulweliCoding.FraudSignalEngine.Rules.*;
import com.MulweliCoding.FraudSignalEngine.Repository.TransactionRepository;
import com.MulweliCoding.FraudSignalEngine.Model.Transaction;


@Service
public class FraudEngineService {
    private List<RuleInterface> rules;
    private TransactionRepository transactionRepository;

    public FraudEngineService(List<RuleInterface> rules, TransactionRepository transactionRepository) {
        this.rules = rules;
        this.transactionRepository = transactionRepository;
    }

    public int evaluateTransaction(Transaction transaction) {
        System.out.println("Evaluating transaction for user ID: " + transaction.getUserId());
        List<Transaction> pastTransactions = transactionRepository.findByUserId(transaction.getUserId());
        int fraudScore = 0;
        for (RuleInterface rule : rules) {
            System.out.println("Applying rule: " + rule.getClass().getSimpleName());
            rule.evaluate(pastTransactions, transaction);
            fraudScore += rule.getRiskScore();
        }
        transactionRepository.save(transaction);
        System.out.println("Fraud score for transaction: " + fraudScore);
        return fraudScore;
    }

}
