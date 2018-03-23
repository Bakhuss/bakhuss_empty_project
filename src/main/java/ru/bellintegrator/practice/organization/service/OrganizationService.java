package ru.bellintegrator.practice.organization.service;

import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.view.OrganizationView;

public interface OrganizationService {

    void add(OrganizationView organization);

    void update(OrganizationView organization);

    OrganizationView findById(Long id);

}
