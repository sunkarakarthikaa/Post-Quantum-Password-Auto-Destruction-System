package com.quantumsecurity.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(nullable = false)
    private String salt;

    @Enumerated(EnumType.STRING)
    @Column(name = "crypto_algorithm", nullable = false)
    private CryptoAlgorithm cryptoAlgorithm;

    @Column(name = "crypto_iterations", nullable = false)
    private Integer cryptoIterations;

    @Column(name = "crypto_memory")
    private Integer cryptoMemory;

    @Column(name = "crypto_version", nullable = false)
    private Integer cryptoVersion;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_status")
    private AccountStatus accountStatus;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public User() {}

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    public String getSalt() { return salt; }
    public void setSalt(String salt) { this.salt = salt; }

    public CryptoAlgorithm getCryptoAlgorithm() { return cryptoAlgorithm; }
    public void setCryptoAlgorithm(CryptoAlgorithm cryptoAlgorithm) { this.cryptoAlgorithm = cryptoAlgorithm; }

    public Integer getCryptoIterations() { return cryptoIterations; }
    public void setCryptoIterations(Integer cryptoIterations) { this.cryptoIterations = cryptoIterations; }

    public Integer getCryptoMemory() { return cryptoMemory; }
    public void setCryptoMemory(Integer cryptoMemory) { this.cryptoMemory = cryptoMemory; }

    public Integer getCryptoVersion() { return cryptoVersion; }
    public void setCryptoVersion(Integer cryptoVersion) { this.cryptoVersion = cryptoVersion; }

    public AccountStatus getAccountStatus() { return accountStatus; }
    public void setAccountStatus(AccountStatus accountStatus) { this.accountStatus = accountStatus; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public enum CryptoAlgorithm {
        PBKDF2,
        ARGON2ID
    }

    public enum AccountStatus {
        ACTIVE,
        RECOVERY_MODE,
        BLOCKED
    }
}