package ru.bellintegrator.practice.Error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(ResponsErrorException.class)
    public ResponsError handlerException(ResponsErrorException ex) {
        ResponsError error = new ResponsError(ex.getMessage());
        return error;
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponsError handlerConvertException(ResponsErrorException ex) {
        ResponsError error = new ResponsError(ex.getMessage());
        return error;
    }

}
