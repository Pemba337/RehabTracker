package com.rehabtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rehabtracker.model.Therapist;

@Repository
public interface TherapistRepository extends JpaRepository<Therapist, Long> {
}
