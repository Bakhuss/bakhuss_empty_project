package ru.bellintegrator.practice.office.view;

import io.swagger.annotations.ApiModelProperty;

public class OfficeView {

    @ApiModelProperty(hidden = true)
    public long id;

    public String name;

    public String address;

    public String phone;

    public boolean isActive;

    public String organizationId;


    @Override
    public String toString() {
        return "{id:" + id + ";name:" + name + ";address:" + address +
                ";phone:" + phone + ";isActive:" + isActive + ";organizationId:" + organizationId + "}";
    }
}
