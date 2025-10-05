package com.aiservice.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "recommentdation")  // <-- correct
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recommentdation {
    @Id
    private String id;
    private Long userId;
    private String activityId;
    private String activityType;
    private String recommendation;
    private List<String> improvements;
    private List<String> suggestions;
    private List<String> safety;
    @CreatedDate
    private LocalDateTime createdAt;
}
