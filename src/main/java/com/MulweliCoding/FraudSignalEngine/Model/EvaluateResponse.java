package com.MulweliCoding.FraudSignalEngine.Model;

import java.util.ArrayList;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "EvaluateResponses")
public class EvaluateResponse {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long responseId;
    private long userId;
    private long transactionId;
    private int fraudScore;
    private ArrayList<String> triggeredRules;
    private boolean isFraud;

    public EvaluateResponse() {
        this.userId = 0;
        this.transactionId = 0;
        this.fraudScore = 0;
        this.triggeredRules = new ArrayList<>();
        this.isFraud = false;
    }

    public EvaluateResponse(long userId, long transactionId, int fraudScore, ArrayList<String> triggeredRules, boolean isFraud) {
        this.userId = userId;
        this.transactionId = transactionId;
        this.fraudScore = fraudScore;
        this.triggeredRules = triggeredRules;
        this.isFraud = isFraud;
    }

    public void addTriggeredRule(String rule) {
        this.triggeredRules.add(rule);
    }

    // Getters and Setters
    public long getResponseId() {
        return responseId;
    }       

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public int getFraudScore() {
        return fraudScore;
    }

    public void setFraudScore(int fraudScore) {
        this.fraudScore = fraudScore;
    }

    public ArrayList<String> getTriggeredRules() {
        return triggeredRules;
    }

    public void setTriggeredRules(ArrayList<String> triggeredRules) {
        this.triggeredRules = triggeredRules;
    }

    public boolean isFraud() {
        return isFraud;
    }

    public void setFraud(boolean isFraud) {
        this.isFraud = isFraud;
    }

    
}
