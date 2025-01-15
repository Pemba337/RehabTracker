package com.rehabtracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rehabtracker.model.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    List<Session> findByPatientId(Long patientId);
}
