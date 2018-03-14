package ru.bellintegrator.practice.organization.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.organization.controller.OrganizationController;
import ru.bellintegrator.practice.organization.service.OrganizationService;
import ru.bellintegrator.practice.organization.view.OrganizationView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationControllerImpl implements OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    private OrganizationControllerImpl(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }


    @Override
    @RequestMapping(value = "/save", method = {POST})
    public Boolean addOrganization(@RequestBody OrganizationView organization) {
        return null;
    }

    @Override
    @RequestMapping(value = "/update", method = {POST})
    public Boolean updateOrganization(OrganizationView organization) {
        return null;
    }

    @Override
    @RequestMapping(value = "/delete", method = {POST})
    public Boolean deleteOrganization(Long id) {
        return null;
    }

    @Override
    @RequestMapping(value = "/", method = {GET})
    public OrganizationView getOrganization(Long id) {
        return null;
    }

    @Override
    @RequestMapping(value = "/list", method = {POST})
    public List<OrganizationView> getAllOrganizations(OrganizationView organization) {
        return null;
    }
}
