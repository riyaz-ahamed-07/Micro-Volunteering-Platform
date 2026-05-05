package com.fullstack.assessment.Controllers;

import com.fullstack.assessment.Entities.OrganizationEntity;
import com.fullstack.assessment.Services.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organizations")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    @PostMapping
    public OrganizationEntity createOrganization(@RequestBody OrganizationEntity organization) {
        return organizationService.createOrganization(organization);
    }

    @GetMapping
    public List<OrganizationEntity> getAllOrganizations() {
        return organizationService.getAllOrganizations();
    }

    @GetMapping("/{id}")
    public OrganizationEntity getOrganizationById(@PathVariable Long id) {
        return organizationService.getOrganizationById(id);
    }

    @PutMapping("/{id}")
    public OrganizationEntity updateOrganization(@PathVariable Long id,
                                                 @RequestBody OrganizationEntity organization) {
        return organizationService.updateOrganization(id, organization);
    }

    @DeleteMapping("/{id}")
    public String deleteOrganization(@PathVariable Long id) {
        organizationService.deleteOrganization(id);
        return "Organization deleted successfully";
    }
}