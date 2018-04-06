package ru.bellintegrator.practice;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ResponseView {

    public String result;
    public Object data;


    public ResponseView(){
        result = "success";
    }

    public ResponseView(Object data) {
        result = "success";
        this.data = data;
    }
}
