package ru.bellintegrator.practice.user.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.ResponseView;
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
    public ResponseView addUser(@RequestBody UserView user) {
        return userService.add(user);
    }

    @Override
    @RequestMapping(value = "/update", method = {POST})
    public ResponseView updateUser(@RequestBody UserView user) {
        return userService.update(user);
    }

    @Override
    @RequestMapping(value = "/delete", method = {POST})
    public ResponseView deleteUser(@RequestBody UserView user) {
        return userService.delete(user);
    }

    @Override
    @RequestMapping(value = "/{id}", method = {GET})
    public ResponseView getUser(@PathVariable("id") String id) {
        return userService.findById(id);
    }

    @Override
    @RequestMapping(value = "/list", method = {POST})
    public ResponseView getAllUsers(@RequestBody UserView user) {
        return userService.users();
    }
}
