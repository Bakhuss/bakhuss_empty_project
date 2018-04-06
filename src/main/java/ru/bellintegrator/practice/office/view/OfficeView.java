package ru.bellintegrator.practice.office.view;

import io.swagger.annotations.ApiModelProperty;

public class OfficeView {

    @ApiModelProperty(hidden = true)
    public String id;

    public String name;

    public String address;

    public String phone;

    public boolean isActive;

    public String orgId;


    @Override
    public String toString() {
        return "{id:" + id + ";name:" + name + ";address:" + address +
                ";phone:" + phone + ";isActive:" + isActive + ";organizationId:" + orgId + "}";
    }
}
