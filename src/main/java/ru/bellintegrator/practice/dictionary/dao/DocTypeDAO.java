package ru.bellintegrator.practice.dictionary.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.dictionary.model.DocType;

/**
 * DAO для работы с DocType
 */
@Repository
public interface DocTypeDao extends CrudRepository<DocType, Long> {

    DocType findByName(String name);

}
