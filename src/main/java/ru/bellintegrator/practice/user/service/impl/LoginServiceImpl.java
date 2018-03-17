package ru.bellintegrator.practice.user.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.user.dao.LoginDao;
import ru.bellintegrator.practice.user.service.LoginService;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class LoginServiceImpl implements LoginService {
    private final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);

    private final LoginDao loginDao;

    @Autowired
    private LoginServiceImpl(LoginDao loginDao) {
        this.loginDao = loginDao;
    }
}
