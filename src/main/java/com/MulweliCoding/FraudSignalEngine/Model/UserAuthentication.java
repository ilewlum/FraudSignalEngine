package com.MulweliCoding.FraudSignalEngine.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(name = "User_Auth")
public class UserAuthentication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long userId;
    private String username;

    @Column(name = "password", nullable = false)
    private String passwordHash;
    private Boolean isEnabled;
    private String role;

    // Constructors
    public UserAuthentication() {
        this.username = "";
        this.passwordHash = "";
        this.role = "USER";
        this.isEnabled = false;
    }

    public UserAuthentication(String username, String passwordHash, String role, Boolean enabled) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.role = role;
        this.isEnabled = enabled;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setIsEnabled(boolean isEnabled){
        this.isEnabled = isEnabled;
    }

    public boolean getIsEnabled(){
        return this.isEnabled;
    }
}
