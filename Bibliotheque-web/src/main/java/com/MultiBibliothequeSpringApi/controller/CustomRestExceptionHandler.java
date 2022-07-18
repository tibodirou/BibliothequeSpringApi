package com.MultiBibliothequeSpringApi.controller;

import javax.xml.bind.ValidationException;

import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {
	
    @ResponseBody
    @ExceptionHandler(value = ValidationException.class)
    public ResponseEntity<?> handleException(ValidationException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
    
    @ResponseBody
    @ExceptionHandler(value = PSQLException.class)
    public ResponseEntity<?> handleExceptionSQL(PSQLException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ce livre existe déja");
    }

    @ResponseBody
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<?> handleException(NullPointerException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Champ vide");
    }
    
}
