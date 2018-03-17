package ru.bellintegrator.practice.user.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.user.model.Document;

/**
 * DAO для работы с Document
 */
@Repository
public interface DocumentDao extends CrudRepository<Document, Long> {

}
