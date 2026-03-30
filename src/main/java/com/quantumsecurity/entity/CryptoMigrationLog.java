package com.quantumsecurity.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "crypto_migration_logs")
public class CryptoMigrationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long migrationId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "old_algorithm", nullable = false)
    private CryptoAlgorithm oldAlgorithm;

    @Enumerated(EnumType.STRING)
    @Column(name = "new_algorithm", nullable = false)
    private CryptoAlgorithm newAlgorithm;

    @Column(name = "old_iterations", nullable = false)
    private Integer oldIterations;

    @Column(name = "new_iterations", nullable = false)
    private Integer newIterations;

    @Column(name = "old_memory")
    private Integer oldMemory;

    @Column(name = "new_memory")
    private Integer newMemory;

    @Enumerated(EnumType.STRING)
    @Column(name = "trigger_reason", nullable = false)
    private TriggerReason triggerReason;

    @ManyToOne
    @JoinColumn(name = "threat_id")
    private ThreatLog threat;

    @Column(name = "migrated_at")
    private LocalDateTime migratedAt;

    @PrePersist
    protected void onCreate() {
        this.migratedAt = LocalDateTime.now();
    }

    public enum CryptoAlgorithm {
        PBKDF2,
        ARGON2ID
    }

    public enum TriggerReason {
        MANUAL,
        THREAT_DETECTED,
        SCHEDULED
    }

    public CryptoMigrationLog() {}

    // Getters and Setters
    public Long getMigrationId() { return migrationId; }
    public void setMigrationId(Long migrationId) { this.migrationId = migrationId; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public CryptoAlgorithm getOldAlgorithm() { return oldAlgorithm; }
    public void setOldAlgorithm(CryptoAlgorithm oldAlgorithm) { this.oldAlgorithm = oldAlgorithm; }

    public CryptoAlgorithm getNewAlgorithm() { return newAlgorithm; }
    public void setNewAlgorithm(CryptoAlgorithm newAlgorithm) { this.newAlgorithm = newAlgorithm; }

    public Integer getOldIterations() { return oldIterations; }
    public void setOldIterations(Integer oldIterations) { this.oldIterations = oldIterations; }

    public Integer getNewIterations() { return newIterations; }
    public void setNewIterations(Integer newIterations) { this.newIterations = newIterations; }

    public Integer getOldMemory() { return oldMemory; }
    public void setOldMemory(Integer oldMemory) { this.oldMemory = oldMemory; }

    public Integer getNewMemory() { return newMemory; }
    public void setNewMemory(Integer newMemory) { this.newMemory = newMemory; }

    public TriggerReason getTriggerReason() { return triggerReason; }
    public void setTriggerReason(TriggerReason triggerReason) { this.triggerReason = triggerReason; }

    public ThreatLog getThreat() { return threat; }
    public void setThreat(ThreatLog threat) { this.threat = threat; }

    public LocalDateTime getMigratedAt() { return migratedAt; }
    public void setMigratedAt(LocalDateTime migratedAt) { this.migratedAt = migratedAt; }
}