package ru.bellintegrator.practice.organization.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class OrganizationView {

    @ApiModelProperty(hidden = true)
    public String id;

    public String name;

    public String fullName;

    public String inn;

    public String kpp;

    public String address;

    public String phone;

    public boolean isActive;


    @Override
    public String toString() {
        return "{id:" + id + ";name:" + name + ";fullName:" + fullName + ";inn:" + inn +
                ";kpp:" + kpp + ";address:" + address + ";phone:" + phone + ";isActive:" + isActive + "}";
    }
}
