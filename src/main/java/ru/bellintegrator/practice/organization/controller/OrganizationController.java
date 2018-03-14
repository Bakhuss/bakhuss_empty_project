package ru.bellintegrator.practice.organization.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.bellintegrator.practice.organization.view.OrganizationView;

import java.util.List;

public interface OrganizationController {

    /**
     * Add organization
     * @param organization
     * @return success value
     */
    Boolean addOrganization(@RequestBody OrganizationView organization);

    /**
     * Update organization
     * @param organization
     * @return success value
     */
    Boolean updateOrganization(OrganizationView organization);

    /**
     * Delete organization
     * @param id
     * @return success value
     */
    Boolean deleteOrganization(Long id);

    /**
     * Get organization
     * @param id
     * @return JSON organization value
     */
    OrganizationView getOrganization(@PathVariable(required = false) Long id);

    /**
     * Get all organizations
     * @param organization
     * @return JSON organizations values
     */
    List<OrganizationView> getAllOrganizations(OrganizationView organization);

}
