package ru.bellintegrator.practice.organization.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.Error.ResponsErrorException;
import ru.bellintegrator.practice.ResponseView;
import ru.bellintegrator.practice.organization.controller.OrganizationController;
import ru.bellintegrator.practice.organization.service.OrganizationService;
import ru.bellintegrator.practice.organization.view.OrganizationView;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationControllerImpl implements OrganizationController {

    private final OrganizationService orgService;

    @Autowired
    private OrganizationControllerImpl(OrganizationService orgService) {
        this.orgService = orgService;
    }


    @Override
    @PostMapping(value = "/save")
    public ResponseView addOrganization(@RequestBody OrganizationView organization) {
        return orgService.add(organization);
    }

    @Override
    @PostMapping(value = "/update")
    public ResponseView updateOrganization(@RequestBody OrganizationView organization) {
        return orgService.update(organization);
    }

    @Override
    @PostMapping(value = "/delete")
    public ResponseView deleteOrganization(@RequestBody OrganizationView organization) {
        return orgService.delete(organization);
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseView getOrganization(@PathVariable("id") String id) {
        return orgService.findById(id);
    }

    @Override
    @PostMapping(value = "/list")
    public ResponseView getAllOrganizations(@RequestBody OrganizationView organization) {
        return orgService.organizations(organization);

    }
}
