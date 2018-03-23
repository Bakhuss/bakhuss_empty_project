package ru.bellintegrator.practice.organization.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.organization.dao.OrganizationDao;
import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.service.OrganizationService;
import ru.bellintegrator.practice.organization.view.OrganizationView;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class OrganizationServiceImpl implements OrganizationService {
    private final Logger log = LoggerFactory.getLogger(OrganizationServiceImpl.class);

    private final OrganizationDao orgDao;

    @Autowired
    private OrganizationServiceImpl(OrganizationDao orgDao) {
        this.orgDao = orgDao;
    }


    @Override
    @Transactional
    public void add(OrganizationView organization) {
        Organization org = new Organization();
        org.setName(organization.name);
        org.setFullName(organization.fullName);
        org.setInn(organization.inn);
        org.setKpp(organization.kpp);
        org.setAddress(organization.address);
        org.setPhone(organization.phone);
        org.setActive(organization.isActive);

        orgDao.save(org);
    }

    @Override
    @Transactional
    public void update(OrganizationView organization) {
        Organization org = findById(organization.id);
        org.setName(organization.name);
        org.setFullName(organization.fullName);
        org.setInn(organization.inn);
        org.setKpp(organization.kpp);
        org.setAddress(organization.address);
        org.setPhone(organization.phone);
        org.setActive(organization.isActive);

        orgDao.save(org);
    }

    @Override
    @Transactional
    public OrganizationView findById(Long id) {
        Organization org = orgDao.findOne(id);
        OrganizationView orgView = new OrganizationView();
        orgView.id = org.getId();
        return orgView;
    }
}
