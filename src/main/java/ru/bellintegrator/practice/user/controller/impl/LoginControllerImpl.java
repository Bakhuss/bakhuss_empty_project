package ru.bellintegrator.practice.user.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.user.controller.LoginController;
import ru.bellintegrator.practice.user.service.LoginService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/login", produces = APPLICATION_JSON_VALUE)
public class LoginControllerImpl implements LoginController {

    private final LoginService loginService;

    @Autowired
    private LoginControllerImpl(LoginService loginService) {
        this.loginService = loginService;
    }
}
