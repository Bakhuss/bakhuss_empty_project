package ru.bellintegrator.practice.organization.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.organization.model.Organization;

import java.util.List;

/**
 * DAO для работы с Organization
 */
@Repository
public interface OrganizationDao extends CrudRepository<Organization, Long> {

    @Query("SELECT NEW ru.bellintegrator.practice.organization.model.Organization (" +
            "o.id, o.name, o.isActive) FROM Organization o WHERE " +
            "o.name like ?1% AND o.inn like ?2% AND o.isActive like ?3")
    List<Organization> findOrganizationsByFilter(String name,
                                                  String inn,
                                                  Boolean isActive);

    List<Organization> findByIdIn(List<Long> ids);

}
