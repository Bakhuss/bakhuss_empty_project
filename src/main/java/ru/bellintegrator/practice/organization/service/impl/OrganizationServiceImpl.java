package ru.bellintegrator.practice.organization.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.Error.ResponsErrorException;
import ru.bellintegrator.practice.ResponseView;
import ru.bellintegrator.practice.organization.dao.OrganizationDao;
import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.service.OrganizationService;
import ru.bellintegrator.practice.organization.view.OrganizationView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class OrganizationServiceImpl implements OrganizationService {
    private final Logger log = LoggerFactory.getLogger(OrganizationServiceImpl.class);

    private final OrganizationDao orgDao;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao orgDao) {
        this.orgDao = orgDao;
    }


    @Override
    @Transactional
    public ResponseView add(OrganizationView organization) {
        Organization org = new Organization();
        org.setName(organization.name);
        org.setFullName(organization.fullName);
        org.setInn(organization.inn);
        org.setKpp(organization.kpp);
        org.setAddress(organization.address);
        org.setPhone(organization.phone);
        org.setActive(organization.isActive);
        try {
            orgDao.save(org);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw new ResponsErrorException("Error saving organization");
        }
        return new ResponseView();
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseView findById(String id) {
        Long idL = null;
        try {
            idL = Long.valueOf(id);
        } catch (NumberFormatException ex) {
            log.warn(ex.getMessage());
            throw new ResponsErrorException("Organization id must be a number");
        }

        Organization org = null;
        OrganizationView orgView = null;
        try {
            org = orgDao.findOne(idL);
            orgView = new OrganizationView();
            orgView.id = org.getId().toString();
            orgView.name = org.getName();
            orgView.fullName = org.getFullName();
            orgView.inn = org.getInn();
            orgView.kpp = org.getKpp();
            orgView.address = org.getAddress();
            orgView.phone = org.getPhone();
            orgView.isActive = org.getActive();
        } catch (NullPointerException ex) {
            log.error(ex.getMessage());
            throw new ResponsErrorException("Not found organization by id = " + idL);
        }
        return new ResponseView(orgView);
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseView organizations(OrganizationView organization) {
        if (organization.name == null) {
            throw new ResponsErrorException("The name is a required search parameter");
        }

        List<Organization> org = orgDao.findOrganizationsByFilter(organization.name, organization.inn, organization.isActive);

        Function<Organization, OrganizationView> orgFunc = p -> {
            OrganizationView o = new OrganizationView();
            o.id = p.getId().toString();
            o.name = p.getName();
            o.isActive = p.getActive();
            return o;
        };

        ResponseView view = new ResponseView();
        view.result = null;
        view.data =
                org.stream()
                        .map(orgFunc)
                        .collect(Collectors.toList());

        return view;
    }

    @Override
    @Transactional
    public ResponseView update(OrganizationView organization) {
        Organization org = orgDao.findOne(Long.valueOf(organization.id));
        org.setName(organization.name);
        org.setFullName(organization.fullName);
        org.setInn(organization.inn);
        org.setKpp(organization.kpp);
        org.setAddress(organization.address);
        org.setPhone(organization.phone);
        org.setActive(organization.isActive);
        try {
            orgDao.save(org);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw new ResponsErrorException("Error updating organization");
        }
        return new ResponseView();
    }

    @Override
    @Transactional
    public ResponseView delete(OrganizationView organization) {
        try {
            orgDao.delete(Long.valueOf(organization.id));
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw new ResponsErrorException("Error deleting organization by id = " + organization.id);
        }
        return new ResponseView();
    }
}
