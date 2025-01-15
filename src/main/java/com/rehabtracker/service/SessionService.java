package com.rehabtracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rehabtracker.model.Session;
import com.rehabtracker.repository.SessionRepository;

@Service
public class SessionService {
    @Autowired
    private SessionRepository sessionRepository;
    
    public Session saveSession(Session session) {
        return sessionRepository.save(session);
    }

    public List<Session> getSessionsForPatient(Long patientId) {
        return sessionRepository.findByPatientId(patientId);
    }

    public Session logSession(Session session) {
        return sessionRepository.save(session);
    }
}
