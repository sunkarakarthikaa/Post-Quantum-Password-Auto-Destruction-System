package com.quantumsecurity.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "threat_logs")
public class ThreatLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long threatId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "threat_type", nullable = false)
    private ThreatType threatType;

    @Column(name = "failed_attempt_count", nullable = false)
    private Integer failedAttemptCount;

    @Column(name = "detection_reason")
    private String detectionReason;

    @Column(name = "action_taken", nullable = false)
    private String actionTaken;

    @Column(name = "detected_at")
    private LocalDateTime detectedAt;

    @PrePersist
    protected void onCreate() {
        this.detectedAt = LocalDateTime.now();
    }

    public enum ThreatType {
        BRUTE_FORCE,
        TIMING_ANOMALY,
        QUANTUM_PATTERN,
        RAPID_SUCCESSION
    }

    public ThreatLog() {}

    // Getters and Setters
    public Long getThreatId() { return threatId; }
    public void setThreatId(Long threatId) { this.threatId = threatId; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public ThreatType getThreatType() { return threatType; }
    public void setThreatType(ThreatType threatType) { this.threatType = threatType; }

    public Integer getFailedAttemptCount() { return failedAttemptCount; }
    public void setFailedAttemptCount(Integer failedAttemptCount) { this.failedAttemptCount = failedAttemptCount; }

    public String getDetectionReason() { return detectionReason; }
    public void setDetectionReason(String detectionReason) { this.detectionReason = detectionReason; }

    public String getActionTaken() { return actionTaken; }
    public void setActionTaken(String actionTaken) { this.actionTaken = actionTaken; }

    public LocalDateTime getDetectedAt() { return detectedAt; }
    public void setDetectedAt(LocalDateTime detectedAt) { this.detectedAt = detectedAt; }
}