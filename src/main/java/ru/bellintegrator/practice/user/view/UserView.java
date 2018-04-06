package ru.bellintegrator.practice.user.view;

import io.swagger.annotations.ApiModelProperty;
import ru.bellintegrator.practice.dictionary.view.CountryView;

import java.util.Date;
import java.util.List;

public class UserView {

    @ApiModelProperty(hidden = true)
    public String id;

    public String firstName;

    public String secondName;

    public String middleName;

    public String phone;

    public String eMail;

    public boolean isIdentified;

    /**
     * Document
     */
    public String docType;

    public String docNumber;

    public Date docReceiveDate;

    public Date docExpireDate;

    /**
     * Country
     */
    public List<CountryView> countries;

//    public String citizenshipName;
//
//    public String citizenshipCode;

    /**
     * Login
     */
    public String login;

    /**
     * Position
     */
    public String position;


    @Override
    public String toString() {
        return "{id:" + id + ";firstName:" + firstName + ";secondName:" + secondName +
                ";middleName:" + middleName + ";phone:" + phone + ";isIdentified:" + isIdentified +
                ";document number:" + docNumber + ";login:" + login + ";position:" + position + "}";
    }
}
