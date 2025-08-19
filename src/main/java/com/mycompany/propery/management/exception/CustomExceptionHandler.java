package com.mycompany.propery.management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException be) {
        System.out.println("BusinessException");
        return new ResponseEntity<>(be.getErrors(), HttpStatus.BAD_REQUEST);
    }
}
