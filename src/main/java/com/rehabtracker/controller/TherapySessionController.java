
package com.rehabtracker.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rehabtracker.model.TherapySession;
import com.rehabtracker.service.TherapySessionService;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class TherapySessionController {
    private final TherapySessionService service;

    public TherapySessionController(TherapySessionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TherapySession> addSession(@RequestBody TherapySession session) {
    	System.out.println("In save");
        TherapySession created = service.addSession(session);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/patient/{name}")
    public ResponseEntity<List<TherapySession>> getSessionsByPatient(@PathVariable String name) {
        return ResponseEntity.ok(service.getSessionsByPatient(name));
    }

    @GetMapping
    public ResponseEntity<List<TherapySession>> getAllSessions() {
        return ResponseEntity.ok(service.getAllSessions());
    }
}
