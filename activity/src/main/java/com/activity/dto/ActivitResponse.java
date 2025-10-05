package com.activity.dto;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import com.activity.model.ActivityType;

import lombok.Data;

@Data
public class ActivitResponse {
    private String id;
    private Long userId;
    private ActivityType type;
    private Integer duration;
    private Integer caloriedBurned;
    private LocalDateTime startTime;
    
    private Map<String , Object> additionalMatrics;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
