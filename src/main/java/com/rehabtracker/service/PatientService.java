package com.rehabtracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rehabtracker.model.Patient;
import com.rehabtracker.repository.PatientRepository;

@Service
public class PatientService {
	
    @Autowired
    private PatientRepository patientRepository;

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient findPatientByEmail(String email) {
        return patientRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Patient not found"));
    }
    
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + id));
    }
    
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
}

