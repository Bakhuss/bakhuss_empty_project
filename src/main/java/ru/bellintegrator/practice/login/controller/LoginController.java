package ru.bellintegrator.practice.login.controller;

import ru.bellintegrator.practice.ResponseView;
import ru.bellintegrator.practice.login.model.Login;
import ru.bellintegrator.practice.login.view.LoginView;

/**
 * Контроллер для работы с Login
 */
public interface LoginController {

    ResponseView register(LoginView login);

    void activation(String code);

    ResponseView login(Login login);

}
