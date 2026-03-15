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

    public enum AttemptStatus {
        SUCCESS,
        FAILED
    }

    public LoginAttempt() {}

    // Getters and Setters
}