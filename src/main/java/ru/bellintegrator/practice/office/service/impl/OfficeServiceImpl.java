package ru.bellintegrator.practice.office.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.office.dao.OfficeDao;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.service.OfficeService;
import ru.bellintegrator.practice.office.view.OfficeView;
import ru.bellintegrator.practice.organization.dao.OrganizationDao;
import ru.bellintegrator.practice.organization.service.OrganizationService;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class OfficeServiceImpl implements OfficeService {
    private final Logger log = LoggerFactory.getLogger(OfficeServiceImpl.class);

    private final OfficeDao officeDao;
    private final OrganizationService orgService;

    @Autowired
    private OfficeServiceImpl(OfficeDao officeDao, OrganizationService orgService) {
        this.officeDao = officeDao;
        this.orgService = orgService;
    }

    @Override
    @Transactional
    public void addOffice(OfficeView office) {
        Office off = new Office();
        off.setName(office.name);
        off.setAddress(office.address);
        off.setPhone(office.phone);
        off.setActive(false);

        off.setOrganization(orgService.findById(Long.valueOf(office.orgId)));

        officeDao.save(off);
    }

    @Override
    @Transactional
    public void updateOffice(OfficeView office) {
        Office off = findById(office.id);
        off.setName(office.name);
        off.setAddress(office.address);
        off.setPhone(office.phone);
        off.setActive(office.isActive);
        off.setOrganization(orgService.findById(Long.valueOf(office.orgId)));

        officeDao.save(off);
    }

    @Override
    @Transactional
    public OfficeView findById(Long id) {
        Office off = officeDao.findOne(id);
        OfficeView offView = new OfficeView();
        offView
        return officeDao.findOne(id);
    }
}
