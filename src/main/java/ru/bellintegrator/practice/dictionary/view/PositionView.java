package ru.bellintegrator.practice.dictionary.view;

import io.swagger.annotations.ApiModelProperty;

public class PositionView {

    @ApiModelProperty(hidden = true)
    public Long id;

    public String name;


    @Override
    public String toString() {
        return "{id:" + id + ";name" + name + "}";
    }
}
