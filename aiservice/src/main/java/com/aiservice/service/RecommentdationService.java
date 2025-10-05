package com.aiservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aiservice.model.Recommentdation;
import com.aiservice.repository.RecommentdationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecommentdationService {

    private final RecommentdationRepository recommentdationRepository;

    public List<Recommentdation> getUserRecommendations(Long userId){
       return recommentdationRepository.findByUserId(userId);
    }

   public Recommentdation getActivityRecommentdation(String activityId){
    return recommentdationRepository.findByActivityId(activityId)
        .orElseThrow(()-> new RuntimeException("Recommendation Not found ....." + activityId));
   }
        
    
    
}
