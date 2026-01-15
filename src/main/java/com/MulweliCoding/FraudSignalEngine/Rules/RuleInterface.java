package com.MulweliCoding.FraudSignalEngine.Rules;
import com.MulweliCoding.FraudSignalEngine.Model.Transaction;
import java.util.List;

public interface RuleInterface {
    String getName();
    String getDescription();
    int getRiskScore();
    void evaluate(List<Transaction> transactions, Transaction transaction); 
}
