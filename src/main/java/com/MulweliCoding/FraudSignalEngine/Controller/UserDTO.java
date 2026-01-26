package com.MulweliCoding.FraudSignalEngine.Controller;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class UserDTO {
    private String name;
    private String email;
    private String phoneNumber;
    private String region;

    // Constructors
    public UserDTO(String name, String email, String phoneNumber, String region) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.region = region;
    }

    // Getters and Setters
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
        return "Username=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber + ", region=" + region + "]";
    }
}
