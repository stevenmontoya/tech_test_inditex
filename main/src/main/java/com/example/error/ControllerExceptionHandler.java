package com.example.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> ProductNotFoundExceptionHandler(final ProductNotFoundException productNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(productNotFoundException.getMessage());
    }
}
