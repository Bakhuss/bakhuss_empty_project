package ru.bellintegrator.practice.user.controller;

import ru.bellintegrator.practice.ResponseView;
import ru.bellintegrator.practice.user.view.UserView;

/**
 * Controller для работы с User
 */
public interface UserController {

    /**
     * Add user
     * @param user
     * @return success value
     */
    ResponseView addUser(UserView user);

    /**
     * Update user
     * @param user
     * @return success value
     */
    ResponseView updateUser(UserView user);

    /**
     * Delete user
     * @param id
     * @return success value
     */
    ResponseView deleteUser(UserView user);

    /**
     * Get user
     * @param id
     * @return JSON user value
     */
    ResponseView getUser(String id);

    /**
     * Get all users
     * @param user
     * @return JSON users values
     */
    ResponseView getAllUsers(UserView user);

}
