package com.rehabtracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rehabtracker.model.Patient;
import com.rehabtracker.model.Session;
import com.rehabtracker.model.SessionRequest;
import com.rehabtracker.model.Therapist;
import com.rehabtracker.service.PatientService;
import com.rehabtracker.service.SessionService;
import com.rehabtracker.service.TherapistService;

@RestController
@RequestMapping("/sessions")
public class SessionController {
    
    @Autowired
    private SessionService sessionService;
    
    @Autowired
    private PatientService patientService;

    @Autowired
    private TherapistService therapistService;

    @PostMapping("/save")
    public ResponseEntity<Session> saveSession(@RequestBody SessionRequest request) {
        // Fetch patient and therapist from DB
        Patient patient = patientService.getPatientById(request.getPatientId());
        Therapist therapist = therapistService.getTherapistById(request.getTherapistId());

        // Create and save session
        Session session = new Session();
        session.setPatient(patient);
        session.setTherapist(therapist);
        session.setSessionDate(request.getSessionDate());
        session.setActivityLogged(request.getActivityLogged());
        session.setProgressReport(request.getProgressReport());

        Session savedSession = sessionService.saveSession(session);
        return ResponseEntity.ok(savedSession);
    }
    
    @GetMapping("/patient/{patientId}")
    public List<Session> getSessionsForPatient(@PathVariable Long patientId) {
        return sessionService.getSessionsForPatient(patientId);
    }

}
