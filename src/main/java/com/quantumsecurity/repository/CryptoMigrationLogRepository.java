package com.quantumsecurity.repository;

import com.quantumsecurity.entity.CryptoMigrationLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptoMigrationLogRepository extends JpaRepository<CryptoMigrationLog, Long> {

}