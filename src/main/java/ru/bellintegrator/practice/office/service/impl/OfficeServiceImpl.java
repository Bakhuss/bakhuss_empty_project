package ru.bellintegrator.practice.office.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.office.dao.OfficeDao;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.service.OfficeService;
import ru.bellintegrator.practice.office.view.OfficeFilter;
import ru.bellintegrator.practice.office.view.OfficeView;
import ru.bellintegrator.practice.organization.dao.OrganizationDao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class OfficeServiceImpl implements OfficeService {
    private final Logger log = LoggerFactory.getLogger(OfficeServiceImpl.class);

    private final OfficeDao officeDao;
    private final OrganizationDao orgDao;

    @Autowired
    private OfficeServiceImpl(OfficeDao officeDao, OrganizationDao orgDao) {
        this.officeDao = officeDao;
        this.orgDao = orgDao;
    }

    @Override
    @Transactional
    public void add(OfficeView office) {
        Office off = new Office();
        off.setName(office.name);
        off.setAddress(office.address);
        off.setPhone(office.phone);
        off.setActive(false);

        off.setOrganization(orgDao.findOne(Long.valueOf(office.orgId)));

        officeDao.save(off);
    }

    @Override
    @Transactional
    public OfficeView findById(Long id) {
        Office off = officeDao.findOne(id);
        OfficeView offView = new OfficeView();
        offView.id = off.getId();
        offView.name = off.getName();
        offView.address = off.getAddress();
        offView.phone = off.getPhone();
        offView.isActive = off.getActive();
        offView.orgId = off.getOrganization().getId().toString();

        return offView;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OfficeView> offices(OfficeFilter filter) {
        if (filter.orgId == null) return null;

        Long orgId = filter.orgId;

        List<Office> all = orgDao.findOne(orgId).getOffices();
        officeDao.findOfficesByFilter();

        officeDao.findAll(new Specification<Office>() {
            @Override
            public Predicate toPredicate(Root<Office> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {


                return null;
            }
        });

        Function<Office, OfficeView> mapOffice = p -> {
            OfficeView view = new OfficeView();
            view.id = p.getId();
            view.name = p.getName();
            view.isActive = p.getActive();

            log.info(view.toString());

            return view;
        };

        return all.stream()
                .map(mapOffice)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void update(OfficeView office) {
        Office off = officeDao.findOne(office.id);
        off.setName(office.name);
        off.setAddress(office.address);
        off.setPhone(office.phone);
        off.setActive(office.isActive);
        off.setOrganization(orgDao.findOne(Long.valueOf(office.orgId)));

        officeDao.save(off);
    }

    @Override
    public void delete(OfficeView office) {
        officeDao.delete(office.id);
    }
}
