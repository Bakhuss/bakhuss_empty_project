package ru.bellintegrator.practice.user.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.user.model.User;

/**
 * DAO для работы с User
 */
@Repository
public interface UserDao extends CrudRepository<User, Long> {
}
