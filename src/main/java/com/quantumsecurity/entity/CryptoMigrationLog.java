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

}