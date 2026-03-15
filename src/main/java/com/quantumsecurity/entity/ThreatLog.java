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

    public enum ThreatType {
        BRUTE_FORCE,
        TIMING_ANOMALY,
        QUANTUM_PATTERN,
        RAPID_SUCCESSION
    }

    public ThreatLog() {}

}