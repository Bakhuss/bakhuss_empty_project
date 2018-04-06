package ru.bellintegrator.practice.Error;

public class ResponsErrorException extends RuntimeException {

    public ResponsErrorException(String error) {
        super(error);
    }

}
