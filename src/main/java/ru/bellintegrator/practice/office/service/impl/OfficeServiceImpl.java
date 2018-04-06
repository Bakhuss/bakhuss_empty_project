package ru.bellintegrator.practice.office.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.Error.ResponsErrorException;
import ru.bellintegrator.practice.ResponseView;
import ru.bellintegrator.practice.office.dao.OfficeDao;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.service.OfficeService;
import ru.bellintegrator.practice.office.view.OfficeFilter;
import ru.bellintegrator.practice.office.view.OfficeView;
import ru.bellintegrator.practice.organization.dao.OrganizationDao;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class OfficeServiceImpl implements OfficeService {
    private final Logger log = LoggerFactory.getLogger(OfficeServiceImpl.class);

    private final OfficeDao officeDao;
    private final OrganizationDao orgDao;

    @Autowired
    public OfficeServiceImpl(OfficeDao officeDao, OrganizationDao orgDao) {
        this.officeDao = officeDao;
        this.orgDao = orgDao;
    }

    @Override
    @Transactional
    public ResponseView add(OfficeView office) {
        try {
            Office off = new Office();
            off.setName(office.name);
            off.setAddress(office.address);
            off.setPhone(office.phone);
            off.setActive(false);
            off.setOrganization(orgDao.findOne(Long.valueOf(office.orgId)));
            officeDao.save(off);
        } catch (Exception ex) {
            throw new ResponsErrorException("Error saving office");
        }
        return new ResponseView();
    }

    @Override
    @Transactional
    public ResponseView findById(String id) {
        Office off = null;
        try {
            off = officeDao.findOne(Long.valueOf(id));
        } catch (Exception ex) {
            log.warn(ex.getMessage());
            throw new ResponsErrorException("Office id must be a number");
        }

        if (off == null) {
            throw new ResponsErrorException("Not found office by id = " + id);
        }

        OfficeView offView = new OfficeView();
        offView.id = off.getId().toString();
        offView.name = off.getName();
        offView.address = off.getAddress();
        offView.phone = off.getPhone();
        offView.isActive = off.getActive();

        return new ResponseView(offView);
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseView offices(OfficeFilter filter) {
        Long orgId = null;
        String name = null;
        String phone = null;
        Boolean isActive = null;

        orgId = Long.valueOf(filter.orgId);
        name = filter.name;
        phone = filter.phone;
        isActive = filter.isActive;


//        List<Office> all = orgDao.findOne(orgId).getOffices();
//        officeDao.findOfficesByFilter();
//
//
//        Function<Office, OfficeView> mapOffice = p -> {
//            OfficeView view = new OfficeView();
//            view.id = p.getId();
//            view.name = p.getName();
//            view.isActive = p.getActive();
//
//            log.info(view.toString());
//
//            return view;
//
//        };
//
//        return all.stream()
//                .map(mapOffice)
//                .collect(Collectors.toList());
        return null;
    }

    @Override
    @Transactional
    public ResponseView update(OfficeView office) {
        Office off = null;
        Long orgId = null;

        try {
            off = officeDao.findOne(Long.valueOf(office.id));
        } catch (Exception ex) {
            throw new ResponsErrorException("Office id must be a number");
        }
        if (off == null) {
            throw new ResponsErrorException("Not found office by id = " + office.id);
        }

        try {
            orgId = Long.valueOf(office.orgId);
            off.setOrganization(orgDao.findOne(orgId));
        } catch (Exception ex) {
            throw new ResponsErrorException("Organization id is a required search parameter, must be a number");
        }

        off.setName(office.name);
        off.setAddress(office.address);
        off.setPhone(office.phone);
        off.setActive(office.isActive);

        officeDao.save(off);

        return new ResponseView();
    }

    @Override
    @Transactional
    public ResponseView delete(OfficeView office) {
        try {
            officeDao.delete(Long.valueOf(office.id));
        } catch (Exception ex) {
            throw new ResponsErrorException("Error deleting office by id = " + office.id);
        }
        return new ResponseView();
    }
}
