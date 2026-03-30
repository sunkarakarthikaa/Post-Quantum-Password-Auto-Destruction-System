package com.quantumsecurity.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "login_attempts")
public class LoginAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attemptId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "email_attempted", nullable = false)
    private String emailAttempted;

    @Column(name = "ip_address", nullable = false)
    private String ipAddress;

    @Column(name = "user_agent")
    private String userAgent;

    @Enumerated(EnumType.STRING)
    @Column(name = "attempt_status", nullable = false)
    private AttemptStatus attemptStatus;

    @Column(name = "response_time_ms", nullable = false)
    private Integer responseTimeMs;

    @Column(name = "attempted_at")
    private LocalDateTime attemptedAt;

    @PrePersist
    protected void onCreate() {
        this.attemptedAt = LocalDateTime.now();
    }

    public enum AttemptStatus {
        SUCCESS,
        FAILED
    }

    public LoginAttempt() {}

    // Getters and Setters
    public Long getAttemptId() { return attemptId; }
    public void setAttemptId(Long attemptId) { this.attemptId = attemptId; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getEmailAttempted() { return emailAttempted; }
    public void setEmailAttempted(String emailAttempted) { this.emailAttempted = emailAttempted; }

    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }

    public String getUserAgent() { return userAgent; }
    public void setUserAgent(String userAgent) { this.userAgent = userAgent; }

    public AttemptStatus getAttemptStatus() { return attemptStatus; }
    public void setAttemptStatus(AttemptStatus attemptStatus) { this.attemptStatus = attemptStatus; }

    public Integer getResponseTimeMs() { return responseTimeMs; }
    public void setResponseTimeMs(Integer responseTimeMs) { this.responseTimeMs = responseTimeMs; }

    public LocalDateTime getAttemptedAt() { return attemptedAt; }
    public void setAttemptedAt(LocalDateTime attemptedAt) { this.attemptedAt = attemptedAt; }
}