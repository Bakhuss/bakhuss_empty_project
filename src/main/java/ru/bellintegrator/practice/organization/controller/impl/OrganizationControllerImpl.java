package ru.bellintegrator.practice.organization.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    private final OrganizationService orgService;

    @Autowired
    private OrganizationControllerImpl(OrganizationService orgService) {
        this.orgService = orgService;
    }


    @Override
    @RequestMapping(value = "/save", method = {POST})
    public void addOrganization(@RequestBody OrganizationView organization) {
        orgService.add(organization);
    }

    @Override
    @RequestMapping(value = "/update", method = {POST})
    public void updateOrganization(OrganizationView organization) {
        
    }

    @Override
    @RequestMapping(value = "/delete", method = {POST})
    public void deleteOrganization(Long id) {

    }

    @Override
    @RequestMapping(value = "/{id}", method = {GET})
    public OrganizationView getOrganization(@PathVariable("id") Long id) {
        return null;
    }

    @Override
    @RequestMapping(value = "/list", method = {POST})
    public List<OrganizationView> getAllOrganizations(OrganizationView organization) {
        return null;
    }
}
