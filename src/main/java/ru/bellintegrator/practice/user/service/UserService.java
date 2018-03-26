package ru.bellintegrator.practice.user.service;

import ru.bellintegrator.practice.user.view.UserView;

import java.util.List;

public interface UserService {

    void add(UserView user);

    UserView findById(Long id);

    List<UserView> users();

    void update(UserView user);

    void delete(UserView user);
}
