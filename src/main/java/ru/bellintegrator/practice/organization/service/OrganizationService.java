package ru.bellintegrator.practice.organization.service;

import ru.bellintegrator.practice.organization.view.OrganizationView;

import java.util.List;

public interface OrganizationService {

    void add(OrganizationView organization);

    OrganizationView findById(Long id);

    List<OrganizationView> organizations();

    void update(OrganizationView organization);

    void delete(OrganizationView organization);

}
