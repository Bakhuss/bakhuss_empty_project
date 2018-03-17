package ru.bellintegrator.practice.user.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.user.model.Login;

/**
 * DAO для работы с Login
 */
@Repository
public interface LoginDao extends CrudRepository<Login, Long> {
}
