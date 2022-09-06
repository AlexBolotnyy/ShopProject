package com.bolotnyi.shop.model.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class BusinessExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(NOT_FOUND)
    public ErrorMessage businessException(BusinessException ex) {
        return new ErrorMessage(ex.getMessage());
    }
}
