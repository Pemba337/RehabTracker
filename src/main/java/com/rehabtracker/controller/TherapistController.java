package com.rehabtracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rehabtracker.model.Therapist;
import com.rehabtracker.service.TherapistService;

@RestController
@RequestMapping("/therapists")
public class TherapistController {
    
    @Autowired
    private TherapistService therapistService;

    @PostMapping("/save")
    public ResponseEntity<Therapist> saveTherapist(@RequestBody Therapist therapist) {
        Therapist savedTherapist = therapistService.saveTherapist(therapist);
        return ResponseEntity.ok(savedTherapist);
    }
    
    @GetMapping("/all")
    public List<Therapist> getAllTherapists() {
        return therapistService.getAllTherapists();
    }
}
