package ru.bellintegrator.practice.Error;

public class ResponsErrorException extends NullPointerException {

    public ResponsErrorException(String error) {
        super(error);
    }

}
