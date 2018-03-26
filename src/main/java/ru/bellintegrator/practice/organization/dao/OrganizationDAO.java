package ru.bellintegrator.practice.organization.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.organization.model.Organization;

/**
 * DAO для работы с Organization
 */
@Repository
public interface OrganizationDao extends CrudRepository<Organization, Long> {
}

//@Repository
//public interface OrganizationDao extends JpaRepository<Organization, Long>{}
