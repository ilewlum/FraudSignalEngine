package com.MulweliCoding.FraudSignalEngine.Model;

import jakarta.annotation.Generated;

public class Transaction {
    // Instance variables
    private long transactionId;
    private long userId;
    private double amount;
    private String timestamp;
    private String location;

    // Contructors
    //default constructor
    public Transaction() {
        this.userId = 0;
        this.amount = 0.0;
        this.timestamp = "";
        this.location = "";
    }

    // copy constructor
    public Transaction(Transaction other) {
        this.userId = other.userId;
        this.amount = other.amount;
        this.timestamp = other.timestamp;
        this.location = other.location;
    }

    // parameterized constructor
    public Transaction(long userId, double amount, String timestamp, String location) {
        this.userId = userId;
        this.amount = amount;
        this.timestamp = timestamp;
        this.location = location;
    }

    // Getters and Setters
    public long getTransactionId() {
        return transactionId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public long getUserId() {
        return userId;
    }       

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String toString() {
        return "Transaction [transactionId=" + transactionId + ", userId=" + userId + ", amount=" + amount
                + ", timestamp=" + timestamp + ", location=" + location + "]";
    }
}
