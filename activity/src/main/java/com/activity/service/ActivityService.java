package com.activity.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.activity.dto.ActivitResponse;
import com.activity.dto.ActivityRquest;
import com.activity.model.Activity;
import com.activity.repository.ActivityRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivityService {
    private final ActivityRepository activityRepository;
    private final UserValidationService userValidationService;

   

    public ActivitResponse tracActiviy(ActivityRquest request) {
         boolean isValidateUser = userValidationService.validateUser(request.getUserId());
         if(!isValidateUser){
            throw new RuntimeException("invalid User id : " + request.getUserId());
         }
        Activity activity = Activity.builder()
            .userId(request.getUserId())
            .type(request.getType())
            .duration(request.getDuration())
            .caloriedBurned(request.getCaloriedBurned())
            .startTime(request.getStartTime())
            .additionalMatrics(request.getAdditionalMatrics())
            .build();
       Activity savedActivity = activityRepository.save(activity);
        
        return mapToReponse(savedActivity);
    }
    private ActivitResponse mapToReponse(Activity activity){
        ActivitResponse activitResponse = new ActivitResponse();
        activitResponse.setId(activity.getId());
        activitResponse.setUserId(activity.getUserId());
        activitResponse.setType(activity.getType());
        activitResponse.setDuration(activity.getDuration());
        activitResponse.setCaloriedBurned(activity.getCaloriedBurned());
        activitResponse.setStartTime(activity.getStartTime());
        activitResponse.setAdditionalMatrics(activity.getAdditionalMatrics());
        activitResponse.setCreatedAt(activity.getCreatedAt());
        activitResponse.setUpdatedAt(activity.getUpdatedAt());
        return activitResponse;


    }
    public List<ActivitResponse> getUserActivity(Long userId) {
        List<Activity> activities = activityRepository.findByUserId(userId);
       return activities.stream().map(this::mapToReponse).collect(Collectors.toList());
        
    }
}
