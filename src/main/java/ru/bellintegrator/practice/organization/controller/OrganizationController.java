package ru.bellintegrator.practice.organization.controller;

import ru.bellintegrator.practice.ResponseView;
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
    ResponseView addOrganization(OrganizationView organization);

    /**
     * Update organization
     * @param organization
     * @return success value
     */
    ResponseView updateOrganization(OrganizationView organization);

    /**
     * Delete organization
     * @param id
     * @return success value
     */
    ResponseView deleteOrganization(OrganizationView organization);

    /**
     * Get organization
     * @param id
     * @return JSON organization value
     */
    ResponseView getOrganization(String id);

    /**
     * Get all organizations
     * @param organization
     * @return JSON organizations values
     */
    ResponseView getAllOrganizations(OrganizationView organization);

}
