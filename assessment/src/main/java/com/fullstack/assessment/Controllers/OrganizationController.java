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
    public OrganizationEntity createOrg(@RequestBody OrganizationEntity organization) {
        return organizationService.createOrg(organization);
    }

    @GetMapping
    public List<OrganizationEntity> getAllOrg() {
        return organizationService.getAllOrg();
    }

    @GetMapping("/{id}")
    public OrganizationEntity getOrgById(@PathVariable Long id) {
        return organizationService.getOrgById(id);
    }

    @PutMapping("/{id}")
    public OrganizationEntity updateOrg(@PathVariable Long id, @RequestBody OrganizationEntity organization) {
        return organizationService.updateOrg(id, organization);
    }

    @DeleteMapping("/{id}")
    public String deleteOrg(@PathVariable Long id) {
        organizationService.deleteOrg(id);
        return "Organization deleted successfully";
    }
}