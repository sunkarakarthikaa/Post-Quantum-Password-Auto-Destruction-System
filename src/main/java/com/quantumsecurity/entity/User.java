package com.quantumsecurity.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password_hash;

    @Column(nullable = false)
    private String salt;

    @Column(nullable = false)
    private String crypto_algorithm;

    @Column(nullable = false)
    private Integer crypto_iterations;

    private Integer crypto_memory;

    @Column(nullable = false)
    private String account_status;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    public User() {}

    // Getters and Setters

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getCrypto_algorithm() {
        return crypto_algorithm;
    }

    public void setCrypto_algorithm(String crypto_algorithm) {
        this.crypto_algorithm = crypto_algorithm;
    }

    public Integer getCrypto_iterations() {
        return crypto_iterations;
    }

    public void setCrypto_iterations(Integer crypto_iterations) {
        this.crypto_iterations = crypto_iterations;
    }

    public Integer getCrypto_memory() {
        return crypto_memory;
    }

    public void setCrypto_memory(Integer crypto_memory) {
        this.crypto_memory = crypto_memory;
    }

    public String getAccount_status() {
        return account_status;
    }

    public void setAccount_status(String account_status) {
        this.account_status = account_status;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
}