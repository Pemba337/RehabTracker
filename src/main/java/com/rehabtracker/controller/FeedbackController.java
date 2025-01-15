package com.rehabtracker.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rehabtracker.model.TherapyData;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @PostMapping("/evaluate")
    public String evaluatePerformance(@RequestBody TherapyData data) {
        // Simulate feedback evaluation
        String feedback = generateFeedback(data);
        return feedback;
    }

    private String generateFeedback(TherapyData data) {
        if (data.getExercisesCompleted() < 5) {
            return "Try to complete more exercises tomorrow!";
        } else if (data.getRangeOfMotion() < 70) {
            return "Great job! Try to increase your range of motion tomorrow!";
        } else {
            return "Excellent work! Keep it up!";
        }
    }
}

