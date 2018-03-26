package ru.bellintegrator.practice.user.view;

import io.swagger.annotations.ApiModelProperty;

public class UserView {

    @ApiModelProperty(hidden = true)
    public long id;

    public String firstName;

    public String secondName;

    public String middleName;

    public String phone;

    public boolean isIdentified;

    public String documentId;

    public String loginId;

    public String positionId;


    @Override
    public String toString() {
        return "{id:" + id + ";firstName:" + firstName + ";secondName:" + secondName +
                ";middleName:" + middleName + ";phone:" + phone + ";isIdentified:" + isIdentified +
                ";documentId" + documentId + ";loginId" + loginId + ";positionId:" + positionId + "}";
    }
}
