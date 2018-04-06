package ru.bellintegrator.practice.organization.service;

import ru.bellintegrator.practice.ResponseView;
import ru.bellintegrator.practice.organization.view.OrganizationView;

import java.util.List;

public interface OrganizationService {

    ResponseView add(OrganizationView organization);

    ResponseView findById(String id);

    ResponseView organizations(OrganizationView organization);

    ResponseView update(OrganizationView organization);

    ResponseView delete(OrganizationView organization);

}
