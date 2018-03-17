package ru.bellintegrator.practice.user.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.user.controller.UserController;
import ru.bellintegrator.practice.user.service.UserService;
import ru.bellintegrator.practice.user.view.UserView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/user", produces = APPLICATION_JSON_VALUE)
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Autowired
    private UserControllerImpl(UserService userService) {
        this.userService = userService;
    }


    @Override
    @RequestMapping(value = "/save", method = {POST})
    public void addUser(UserView user) {

    }

    @Override
    @RequestMapping(value = "/update", method = {POST})
    public void updateUser(UserView user) {

    }

    @Override
    @RequestMapping(value = "/delete", method = {POST})
    public void deleteUser(Long id) {

    }

    @Override
    @RequestMapping(value = "/", method = {GET})
    public UserView getUser(Long id) {
        return null;
    }

    @Override
    @RequestMapping(value = "/list", method = {POST})
    public List<UserView> getAllUsers(UserView user) {
        return null;
    }
}
