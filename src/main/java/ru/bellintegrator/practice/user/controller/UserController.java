package ru.bellintegrator.practice.user.controller;

import ru.bellintegrator.practice.user.view.UserView;

import java.util.List;

/**
 * Controller для работы с User
 */
public interface UserController {

    /**
     * Add user
     * @param user
     * @return success value
     */
    void addUser(UserView user);

    /**
     * Update user
     * @param user
     * @return success value
     */
    void updateUser(UserView user);

    /**
     * Delete user
     * @param id
     * @return success value
     */
    void deleteUser(Long id);

    /**
     * Get user
     * @param id
     * @return JSON user value
     */
    UserView getUser(Long id);

    /**
     * Get all users
     * @param user
     * @return JSON users values
     */
    List<UserView> getAllUsers(UserView user);

}
