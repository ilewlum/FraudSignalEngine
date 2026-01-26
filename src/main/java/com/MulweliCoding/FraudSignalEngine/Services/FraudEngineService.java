package com.MulweliCoding.FraudSignalEngine.Services;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.stereotype.Service;

import com.MulweliCoding.FraudSignalEngine.Rules.*;
import com.MulweliCoding.FraudSignalEngine.Repository.TransactionRepository;
import com.MulweliCoding.FraudSignalEngine.Model.Transaction;
import com.MulweliCoding.FraudSignalEngine.Model.EvaluateResponse;


@Service
public class FraudEngineService {
    private List<RuleInterface> rules;
    private TransactionRepository transactionRepository;

    public FraudEngineService(List<RuleInterface> rules, TransactionRepository transactionRepository) {
        this.rules = rules;
        this.transactionRepository = transactionRepository;
    }

    public EvaluateResponse evaluateTransaction(Transaction transaction) {
        System.out.println("Transaction evaluating.");
        EvaluateResponse response = new EvaluateResponse();

        response.setUserId(transaction.getUserId());
        response.setTransactionId(transaction.getTransactionId());
        List<Transaction> pastTransactions = transactionRepository.findByUserId(transaction.getUserId());
        int fraudScore = 0;
        System.out.println("Applying rules...");
        for (RuleInterface rule : rules) {
            rule.evaluate(pastTransactions, transaction);
            fraudScore += rule.getRiskScore();
            if (rule.isTriggered()) {
                response.addTriggeredRule(rule.getRuleName());
            }
        }
        System.out.println("saving transaction...");
        transactionRepository.save(transaction);
        response.setFraudScore(fraudScore);
        response.setFraud(fraudScore >= 50);
        return response;
    }

}
