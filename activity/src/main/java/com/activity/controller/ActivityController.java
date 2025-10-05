package com.activity.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.activity.dto.ActivitResponse;
import com.activity.dto.ActivityRquest;
import com.activity.service.ActivityService;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/activities")
@Data

public class ActivityController {

    private  final ActivityService activities;

    

public ActivityController(ActivityService activities) {
    this.activities = activities;
}

@PostMapping
    public  ResponseEntity<ActivitResponse> trackActivity(@RequestBody ActivityRquest request){
        return ResponseEntity.ok(activities.tracActiviy(request));
    }
    @GetMapping

    public  ResponseEntity<List<ActivitResponse>> getUserActivity(@RequestHeader("X-User-ID") Long userId){
        return ResponseEntity.ok(activities.getUserActivity(userId));
    }
}
