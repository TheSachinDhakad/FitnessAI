package com.fitness.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data

public class UserResponse {
   
    private Long id;
    private String email;
   
    private String password;
    private String firstName;
    private String lastName;
   
   
    private LocalDateTime createdAt;
   
    private LocalDateTime updatedAt;
}
