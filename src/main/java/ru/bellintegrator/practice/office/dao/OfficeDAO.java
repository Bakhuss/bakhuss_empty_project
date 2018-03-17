package ru.bellintegrator.practice.office.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.office.model.Office;

/**
 * DAO для работы с Office
 */
@Repository
public interface OfficeDao extends CrudRepository<Office, Long> {
}
