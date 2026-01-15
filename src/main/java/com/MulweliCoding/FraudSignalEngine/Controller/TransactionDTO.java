package com.MulweliCoding.FraudSignalEngine.Controller;

public class TransactionDTO {
    //instance variables
    private long userId;
    private double amount;
    private String timestamp;
    private String location;

    //constructors
    //default constructor
    public TransactionDTO() {
        this.userId = 0;
        this.amount = 0.0;
        this.timestamp = "";
        this.location = "";
    }

    //parameterized constructor
    public TransactionDTO(long userId, double amount, String timestamp, String location) {
        this.userId = userId;
        this.amount = amount;
        this.timestamp = timestamp;
        this.location = location;
    }

    // Getters and Setters
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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
    
}
