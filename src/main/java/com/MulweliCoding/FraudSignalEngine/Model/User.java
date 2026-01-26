package com.MulweliCoding.FraudSignalEngine.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "users")
public class User {
    // Instance variables
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    private String name;
    private String email;
    private String phoneNumber;
    private String region;

    // Constructors
    public User() {
        this.name = "";
        this.email = "";
        this.phoneNumber = "";
        this.region = "";
    } 

    public User(User other) {
        this.name = other.name;
        this.email = other.email;
        this.phoneNumber = other.phoneNumber;
        this.region = other.region;
    }

    public User(String name, String email, String phoneNumber, String region) {

        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.region = region;
    }

    // Getters and Setters
    public long getUserId() {
        return userId;
    }       

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String toString() {
        return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber + ", region=" + region + "]";
    }

}
