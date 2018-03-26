package ru.bellintegrator.practice.user.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.dictionary.dao.PositionDao;
import ru.bellintegrator.practice.user.dao.UserDao;
import ru.bellintegrator.practice.user.model.User;
import ru.bellintegrator.practice.user.service.UserService;
import ru.bellintegrator.practice.user.view.UserView;

import java.util.List;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class UserServiceImpl implements UserService {
    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserDao userDao;
    private final PositionDao positionDao;

    @Autowired
    private UserServiceImpl(UserDao userDao, PositionDao positionDao) {
        this.userDao = userDao;
        this.positionDao = positionDao;
    }


    @Override
    public void add(UserView user) {
        User tempUser = new User();
        tempUser.setFirstName(user.firstName);
        tempUser.setSecondName(user.secondName);
        tempUser.setMiddleName(user.middleName);
        tempUser.setPhone(user.phone);
        tempUser.setIdentified(user.isIdentified);
        tempUser.setDocument();
        tempUser.setLogin();
        tempUser.setPosition(positionDao.findOne(Long.valueOf(user.positionId)));

        userDao.save(tempUser);
    }

    @Override
    public UserView findById(Long id) {
        User user = userDao.findOne(id);
        UserView userView = new UserView();
        userView.firstName = user.getFirstName();
        userView.secondName = user.getSecondName();
        userView.middleName = user.getMiddleName();
        userView.phone = user.getPhone();
        userView.isIdentified = user.getIdentified();
        userView.documentId = user.getDocument().getId().toString();
        userView.loginId = user.getLogin().getId().toString();

        return userView;
    }

    @Override
    public List<UserView> users() {
        return null;
    }

    @Override
    public void update(UserView user) {
        User tempUser = userDao.findOne(user.id);
        tempUser.setFirstName(user.firstName);
        tempUser.setSecondName(user.secondName);
        tempUser.setMiddleName(user.middleName);
        tempUser.setPhone(user.phone);
        tempUser.setIdentified(user.isIdentified);
        tempUser.setDocument();
        tempUser.setLogin();
        tempUser.setPosition(positionDao.findOne(Long.valueOf(user.positionId)));

        userDao.save(tempUser);
    }

    @Override
    public void delete(UserView user) {
        userDao.delete(user.id);
    }
}
