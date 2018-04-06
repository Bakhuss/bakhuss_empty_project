package ru.bellintegrator.practice.login.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.ResponseView;
import ru.bellintegrator.practice.login.controller.LoginController;
import ru.bellintegrator.practice.login.model.Login;
import ru.bellintegrator.practice.login.service.LoginService;
import ru.bellintegrator.practice.login.view.LoginView;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class LoginControllerImpl implements LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginControllerImpl(LoginService loginService) {
        this.loginService = loginService;
    }


    @Override
    @PostMapping(value = "/register")
    public ResponseView register(@RequestBody LoginView login) {
        return loginService.addLogin(login);
    }

    @Override
    @GetMapping(value = "/activation")
    public void activation(@RequestParam(value = "code") String code) {

    }

    @Override
    @PostMapping(value = "/login")
    public ResponseView login(@RequestBody Login login) {
        return null;
    }
}
