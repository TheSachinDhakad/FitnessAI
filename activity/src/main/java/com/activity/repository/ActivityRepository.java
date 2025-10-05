package com.activity.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.activity.model.Activity;

public interface ActivityRepository extends MongoRepository<Activity , String>{

     List<Activity> findByUserId(Long userId);
    
}
