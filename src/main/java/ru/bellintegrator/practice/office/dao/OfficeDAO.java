package ru.bellintegrator.practice.office.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.office.model.Office;

import java.util.List;

/**
 * DAO для работы с Office
 */
@Repository
public interface OfficeDao extends CrudRepository<Office, Long>, JpaSpecificationExecutor<Office> {

}
