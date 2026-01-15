package com.MulweliCoding.FraudSignalEngine.Rules;
import com.MulweliCoding.FraudSignalEngine.Model.Transaction;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class GeoLocationRule implements RuleInterface {
    private String name;
    private String description;
    private int riskScore;

    public GeoLocationRule() {
        this.name = "GeoLocation Rule";
        this.description = "Evaluates the transaction based on the geographical location.";
        this.riskScore = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getRiskScore() {
        return riskScore;
    }

    @Override
    public void evaluate(List<Transaction> transactions, com.MulweliCoding.FraudSignalEngine.Model.Transaction transaction) {
        for (Transaction pastTransaction : transactions) {
            if (!pastTransaction.getLocation().equals(transaction.getLocation())) {
                System.out.println("GeoLocation Rule Triggered: Transaction location " + transaction.getLocation() + " differs from past location " + pastTransaction.getLocation() + " for user ID " + transaction.getUserId());
                riskScore += 10;
                break;
            }
        }
        System.out.println(" GeoLocation Rule for transaction ID: " + transaction.getTransactionId() + " evaluated.");
    }
}
