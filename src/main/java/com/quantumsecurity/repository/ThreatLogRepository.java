package com.quantumsecurity.repository;

import com.quantumsecurity.entity.ThreatLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThreatLogRepository extends JpaRepository<ThreatLog, Long> {

}