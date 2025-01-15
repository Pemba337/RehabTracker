package com.rehabtracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rehabtracker.model.Therapist;
import com.rehabtracker.repository.TherapistRepository;

@Service
public class TherapistService {
    
    @Autowired
    private TherapistRepository therapistRepository;

    public Therapist saveTherapist(Therapist therapist) {
        return therapistRepository.save(therapist);
    }
    
    public Therapist getTherapistById(Long id) {
        return therapistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Therapist not found with ID: " + id));
    }
    
    public List<Therapist> getAllTherapists() {
        return therapistRepository.findAll();
    }
}

