package com.fullstack.assessment.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fullstack.assessment.Entities.RewardEntity;

public interface RewardRepo extends JpaRepository<RewardEntity, Integer> {
    
}
