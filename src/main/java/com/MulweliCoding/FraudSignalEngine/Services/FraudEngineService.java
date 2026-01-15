package com.MulweliCoding.FraudSignalEngine.Services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.MulweliCoding.FraudSignalEngine.Rules.*;
import com.MulweliCoding.FraudSignalEngine.Model.Transaction;
import com.MulweliCoding.FraudSignalEngine.Model.Transaction;

@Service
public class FraudEngineService {
    private List<RuleInterface> rules;
    private List<Transaction> pastTransactions;
    private int totalRiskScore;

    public FraudEngineService(List<RuleInterface> rules) {
        this.rules = rules;
        totalRiskScore = 0;
    }

    // filter past transactions by user ID
    public void filterTransactionsByUser(List<Transaction> allTransactions, long userId) {
        pastTransactions = allTransactions.stream()
                .filter(t -> t.getUserId() == userId)
                .toList();
    }

    public int evaluateTransaction(Transaction transaction) {
        for (RuleInterface rule : rules) {
            rule.evaluate(pastTransactions, transaction);
            totalRiskScore += rule.getRiskScore();
        }
        System.out.println("Total Risk Score for transaction ID " + transaction.getTransactionId() + ": " + totalRiskScore);
        return totalRiskScore;
    }

}
