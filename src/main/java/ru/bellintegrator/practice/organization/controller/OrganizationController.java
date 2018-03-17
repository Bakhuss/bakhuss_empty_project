package ru.bellintegrator.practice.organization.controller;

import ru.bellintegrator.practice.organization.view.OrganizationView;

import java.util.List;

/**
 * Controller для работы с Organization
 */
public interface OrganizationController {

    /**
     * Add organization
     * @param organization
     * @return success value
     */
    void addOrganization(OrganizationView organization);

    /**
     * Update organization
     * @param organization
     * @return success value
     */
    void updateOrganization(OrganizationView organization);

    /**
     * Delete organization
     * @param id
     * @return success value
     */
    void deleteOrganization(Long id);

    /**
     * Get organization
     * @param id
     * @return JSON organization value
     */
    OrganizationView getOrganization(Long id);

    /**
     * Get all organizations
     * @param organization
     * @return JSON organizations values
     */
    List<OrganizationView> getAllOrganizations(OrganizationView organization);

}
