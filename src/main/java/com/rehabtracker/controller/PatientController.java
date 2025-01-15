package com.rehabtracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rehabtracker.model.Patient;
import com.rehabtracker.model.Session;
import com.rehabtracker.service.PatientService;
import com.rehabtracker.service.SessionService;

@RestController
@RequestMapping("/patient")
public class PatientController {
	
    @Autowired
    private PatientService patientService;

    @Autowired
    private SessionService sessionService;
    
    @PostMapping("/save")
    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient) {
        Patient savedPatient = patientService.savePatient(patient);
        return ResponseEntity.ok(savedPatient);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return ResponseEntity.ok(patients);
    }

    @GetMapping("/sessions/{patientId}")
    public List<Session> viewSessions(@PathVariable Long patientId) {
        List<Session> sessions = sessionService.getSessionsForPatient(patientId);
        return sessions;
    }

    @PostMapping("/logSession")
    public String logSession(Session session, @RequestParam Long patientId) {
        session.setPatient(patientService.findPatientByEmail("patient@example.com")); // example patient lookup
        sessionService.logSession(session);
        return "redirect:/sessions/" + patientId;
    }
}

