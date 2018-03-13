package ru.bellintegrator.practice.user.controller;

import org.springframework.web.bind.annotation.PathVariable;
import ru.bellintegrator.practice.user.view.UserView;

import java.util.List;

public interface UserController {

    void addUser(UserView user);

    Boolean updateUser(UserView user);

    Boolean deleteUser(Long id);

    UserView getUser(@PathVariable(required = false) Long id);

    List<UserView> getAllUsers(UserView user);

}
