package ru.bellintegrator.practice.user.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.Error.ResponsErrorException;
import ru.bellintegrator.practice.ResponseView;
import ru.bellintegrator.practice.dictionary.dao.CountryDao;
import ru.bellintegrator.practice.dictionary.dao.DocTypeDao;
import ru.bellintegrator.practice.dictionary.dao.PositionDao;
import ru.bellintegrator.practice.dictionary.model.Country;
import ru.bellintegrator.practice.dictionary.view.CountryView;
import ru.bellintegrator.practice.login.dao.LoginDao;
import ru.bellintegrator.practice.user.dao.DocumentDao;
import ru.bellintegrator.practice.user.dao.UserDao;
import ru.bellintegrator.practice.user.model.Document;
import ru.bellintegrator.practice.user.model.User;
import ru.bellintegrator.practice.user.service.UserService;
import ru.bellintegrator.practice.user.view.UserView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class UserServiceImpl implements UserService {
    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserDao userDao;
    private final DocTypeDao docTypeDao;
    private final DocumentDao docDao;
    private final CountryDao countryDao;
    private final PositionDao positionDao;
    private final LoginDao loginDao;

    @Autowired
    public UserServiceImpl(UserDao userDao,
                           DocTypeDao docTypeDao,
                           DocumentDao docDao,
                           CountryDao countryDao,
                           PositionDao positionDao,
                           LoginDao loginDao) {
        this.userDao = userDao;
        this.docTypeDao = docTypeDao;
        this.docDao = docDao;
        this.countryDao = countryDao;
        this.positionDao = positionDao;
        this.loginDao = loginDao;
    }


    @Override
    @Transactional
    public ResponseView add(UserView user) {
        User newUser = new User();
        newUser.setFirstName(user.firstName);
        newUser.setSecondName(user.secondName);
        newUser.setMiddleName(user.middleName);
        newUser.setPhone(user.phone);
        newUser.seteMail(user.eMail);
        newUser.setIdentified(user.isIdentified);
        newUser.setPosition(positionDao.findByName(user.position));
//        newUser.getCitizenships().add(countryDao.findByName());
        User tmpUser = userDao.save(newUser);

        Document newDoc = new Document();
        newDoc.setUser(tmpUser);
        newDoc.setDocType(docTypeDao.findByName(user.docType));
        newDoc.setNumber(user.docNumber);
        newDoc.setReceiveDate(user.docReceiveDate);
        newDoc.setExpireDate(user.docExpireDate);
        docDao.save(newDoc);

        return new ResponseView();
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseView findById(String id) {
        User user = null;
        try {
            user = userDao.findOne(Long.valueOf(id));
        } catch (NumberFormatException ex) {
            throw new ResponsErrorException("Id must be a number");
        }
        if (user == null) throw new ResponsErrorException("Not found user by id = " + id);

        UserView userView = new UserView();
        userView.id = user.getId().toString();
        userView.firstName = user.getFirstName();
        userView.secondName = user.getSecondName();
        userView.middleName = user.getMiddleName();
        userView.position = user.getPosition().getName();
        userView.phone = user.getPhone();
        userView.docType = user.getDocument().getDocType().getName();
        userView.docNumber = user.getDocument().getNumber();
        userView.docReceiveDate = user.getDocument().getReceiveDate();

        Function<Country, CountryView> countryViewFunc = country -> {
            CountryView v = new CountryView();
            v.name = country.getName();
            v.code = country.getCode();
            return v;
        };

        userView.countries = user.getCitizenships()
                .stream()
                .map(countryViewFunc)
                .collect(Collectors.toList());

        userView.isIdentified = user.getIdentified();

        return new ResponseView(userView);
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseView users() {
        return null;
    }

    @Override
    @Transactional
    public ResponseView update(UserView user) {
        User tempUser = null;
        try {
            tempUser = userDao.findOne(Long.parseLong(user.id));
        } catch (NumberFormatException ex) {
            System.out.println("----------" + user.id);
            throw new ResponsErrorException("Id must be a number");
        }
        tempUser.setFirstName(user.firstName);
        tempUser.setSecondName(user.secondName);
        tempUser.setMiddleName(user.middleName);
        tempUser.setPosition(positionDao.findByName(user.position));
        tempUser.setPhone(user.phone);

        Document doc = docDao.findOne(tempUser.getId());

        if (doc == null) {
            doc = new Document();
            doc.setUser(tempUser);
            doc.setDocType(docTypeDao.findByName(user.docType));
            doc.setNumber(user.docNumber);
            doc.setReceiveDate(user.docReceiveDate);
            doc.setExpireDate(user.docExpireDate);
        } else {
            doc.setDocType(docTypeDao.findByName(user.docType));
            doc.setNumber(user.docNumber);
            doc.setReceiveDate(user.docReceiveDate);
            doc.setExpireDate(user.docExpireDate);
        }
        docDao.save(doc);



        tempUser.setIdentified(user.isIdentified);

        userDao.save(tempUser);

        return new ResponseView();
    }

    @Override
    @Transactional
    public ResponseView delete(UserView user) {
        try {
            userDao.delete(Long.valueOf(user.id));
        } catch (NumberFormatException ex) {
            throw new ResponsErrorException("Error removing user by id: " + user.id);
        }
        return new ResponseView();
    }
}
