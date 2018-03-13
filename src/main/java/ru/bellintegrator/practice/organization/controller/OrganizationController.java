package ru.bellintegrator.practice.organization.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.bellintegrator.practice.organization.view.OrganizationView;

import java.util.List;

public interface OrganizationController {

    Boolean addOrganization(@RequestBody OrganizationView organization);

    Boolean updateOrganization(OrganizationView organization);

    Boolean deleteOrganization(Long id);

    OrganizationView getOrganization(@PathVariable(required = false) Long id);

    List<OrganizationView> getAllOrganizations(OrganizationView organization);

}
