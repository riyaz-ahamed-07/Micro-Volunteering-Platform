package com.fullstack.assessment.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fullstack.assessment.Entities.TaskEntity;

public interface TaskRepo extends JpaRepository<TaskEntity, Integer> {
    
}
