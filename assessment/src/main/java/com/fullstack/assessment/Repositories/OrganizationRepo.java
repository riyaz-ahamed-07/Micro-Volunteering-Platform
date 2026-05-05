package com.fullstack.assessment.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fullstack.assessment.Entities.OrganizationEntity;

public interface OrganizationRepo extends JpaRepository<OrganizationEntity, Integer> {
    
}
