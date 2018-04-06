package ru.bellintegrator.practice.login.dao;

import org.springframework.data.repository.CrudRepository;
import ru.bellintegrator.practice.login.model.Login;

public interface LoginDao extends CrudRepository<Login, Long> {
}
