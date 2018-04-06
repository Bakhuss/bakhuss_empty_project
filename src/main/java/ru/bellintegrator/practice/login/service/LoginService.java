package ru.bellintegrator.practice.login.service;

import ru.bellintegrator.practice.ResponseView;
import ru.bellintegrator.practice.login.model.Login;
import ru.bellintegrator.practice.login.view.LoginView;

/**
 * Сервис для работы с Login
 */
public interface LoginService {

    ResponseView addLogin(LoginView login);



}
