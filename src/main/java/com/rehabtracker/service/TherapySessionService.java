
package com.rehabtracker.service;

import org.springframework.stereotype.Service;

import com.rehabtracker.model.Therapist;
import com.rehabtracker.model.TherapySession;
import com.rehabtracker.repository.TherapistRepository;
import com.rehabtracker.repository.TherapySessionRepository;

import java.util.List;

@Service
public class TherapySessionService {
	
    private final TherapySessionRepository repository;
    
    private final TherapistRepository therapistRepository;
		
    public TherapySessionService(TherapySessionRepository repository, TherapistRepository therapistRepository) {
        this.repository = repository;
        this.therapistRepository = therapistRepository;
    }

    public TherapySession addSession(TherapySession session) {
        return repository.save(session);
    }

    public List<TherapySession> getSessionsByPatient(String patientName) {
        return repository.findByPatientName(patientName);
    }

    public List<TherapySession> getAllSessions() {
        return repository.findAll();
    }

	/*
	 * public Therapist saveTherapist(Therapist therapist) { return
	 * therapistRepository.save(therapist); }
	 */
}
