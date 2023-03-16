package com.example.food.customException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public String handleUnexpectedException(Exception e) {
        System.out.println(e.toString());
        return "bad-request-message";
    }
}
