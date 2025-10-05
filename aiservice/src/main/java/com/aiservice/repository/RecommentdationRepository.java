package com.aiservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aiservice.model.Recommentdation;

@Repository
public interface RecommentdationRepository extends MongoRepository<Recommentdation , String>{

    List<Recommentdation> findByUserId(Long userId);
    Optional<Recommentdation> findByActivityId(String activityId);
    
}
