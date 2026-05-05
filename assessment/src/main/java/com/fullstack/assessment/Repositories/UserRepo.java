package com.fullstack.assessment.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fullstack.assessment.Entities.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {
    
}
