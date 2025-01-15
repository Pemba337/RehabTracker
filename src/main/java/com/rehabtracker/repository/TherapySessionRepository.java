
package com.rehabtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rehabtracker.model.TherapySession;

import java.util.List;

@Repository
public interface TherapySessionRepository extends JpaRepository<TherapySession, Long> {
    List<TherapySession> findByPatientName(String patientName);
}
