package com.aiservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aiservice.model.Recommentdation;
import com.aiservice.service.RecommentdationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/recommendation")
@RequiredArgsConstructor
public class RecommentdationControler {
    private final RecommentdationService recommentdationService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Recommentdation>> getUserRecommendation(@PathVariable Long userId){
        return ResponseEntity.ok(recommentdationService.getUserRecommendations(userId));
    }

    @GetMapping("/activity/{activityId}")
    public ResponseEntity<Recommentdation> getActivityRecommentdation(@PathVariable String activityId){
        return ResponseEntity.ok(recommentdationService.getActivityRecommentdation(activityId));
    }

}
