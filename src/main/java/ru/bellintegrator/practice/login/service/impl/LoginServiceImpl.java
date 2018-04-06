package ru.bellintegrator.practice.login.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.Error.ResponsErrorException;
import ru.bellintegrator.practice.ResponseView;
import ru.bellintegrator.practice.login.dao.LoginDao;
import ru.bellintegrator.practice.login.model.Login;
import ru.bellintegrator.practice.login.service.LoginService;
import ru.bellintegrator.practice.login.view.LoginView;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class LoginServiceImpl implements LoginService {
    private final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);

    private final LoginDao loginDao;

    @Autowired
    public LoginServiceImpl(LoginDao loginDao) {
        this.loginDao = loginDao;
    }


    @Override
    public ResponseView addLogin(LoginView login) {

        Login newLogin = new Login();

        newLogin.setLogin(login.login);
        newLogin.setPassword(login.password);
        newLogin.setActive(false);

        try {
            loginDao.save(newLogin);
        } catch (Exception ex) {
            throw new ResponsErrorException("Error saving login");
        }
        return new ResponseView();
    }

    private String generateActivationCode() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String randomCode = UUID.randomUUID().toString();

        MessageDigest encoder = MessageDigest.getInstance("SHA-256");
        byte[] digest = encoder.digest(randomCode.getBytes("UTF-8"));
        return new String(Base64.getEncoder().encode(digest));
    }
}
