package com.mycompany.propery.management.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorModel>> handleFieldValidation(MethodArgumentNotValidException notValidException) {
        List<FieldError> fieldErrors = notValidException.getBindingResult().getFieldErrors();

        List<ErrorModel> errors = fieldErrors.stream().map(fieldError ->
        {
            logger.info("Inside field validation: {} -  {}", fieldError.getField(), fieldError.getDefaultMessage());
            return new ErrorModel(fieldError.getField(), fieldError.getDefaultMessage());
        }).toList();
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException be) {
        System.out.println("BusinessException");
        be.getErrors()
                .forEach(errorModel -> {
                    logger.info("Inside BusinessException: {} -  {}", errorModel.getMessage(), errorModel.getClass());
                });
        return new ResponseEntity<>(be.getErrors(), HttpStatus.BAD_REQUEST);
    }
}
