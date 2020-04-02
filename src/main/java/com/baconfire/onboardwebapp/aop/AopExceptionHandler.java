package com.baconfire.onboardwebapp.aop;

import com.baconfire.onboardwebapp.aop.domain.Info;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.text.ParseException;

@ControllerAdvice
public class AopExceptionHandler {

    @ExceptionHandler(value = ParseException.class)
    public ResponseEntity<Info> handleParseException(ParseException p){
        String errorMessage = "From Controller Advice Parse Exception: " + p.getMessage();
        return ResponseEntity.ok(new Info(errorMessage));
    }
}
