package com.fullstack.assessment.Services;

import com.fullstack.assessment.Entities.OrganizationEntity;
import com.fullstack.assessment.Repositories.OrganizationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganizationRepo repo;

    public OrganizationEntity createOrganization(OrganizationEntity organization) {
        return repo.save(organization);
    }

    public List<OrganizationEntity> getAllOrganizations() {
        return repo.findAll();
    }

    public OrganizationEntity getOrganizationById(Long id) {
        return repo.findById(id);
    }

    public OrganizationEntity updateOrganization(Long id, OrganizationEntity updatedOrg) {
        OrganizationEntity org = getOrganizationById(id);
        org.setName(updatedOrg.getName());
        org.setPhone(updatedOrg.getPhone());
        org.setLocation(updatedOrg.getLocation());
        org.setEmail(updatedOrg.getEmail());
        org.setType(updatedOrg.getType());
        org.setIsVerified(updatedOrg.getIsVerified());
        org.setRegistrationNumber(updatedOrg.getRegistrationNumber());
        return repo.save(org);
    }

    public void deleteOrganization(Long id) {
        repo.deleteById(id);
    }
}