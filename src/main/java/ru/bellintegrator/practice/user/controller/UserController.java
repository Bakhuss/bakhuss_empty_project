package ru.bellintegrator.practice.user.controller;

import org.springframework.web.bind.annotation.PathVariable;
import ru.bellintegrator.practice.user.view.UserView;

import java.util.List;

public interface UserController {

    /**
     * Add user
     * @param user
     * @return success value
     */
    Boolean addUser(UserView user);

    /**
     * Update user
     * @param user
     * @return success value
     */
    Boolean updateUser(UserView user);

    /**
     * Delete user
     * @param id
     * @return success value
     */
    Boolean deleteUser(Long id);

    /**
     * Get user
     * @param id
     * @return JSON user value
     */
    UserView getUser(@PathVariable(required = false) Long id);

    /**
     * Get all users
     * @param user
     * @return JSON users values
     */
    List<UserView> getAllUsers(UserView user);

}
