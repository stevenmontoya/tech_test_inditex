package com.example.error;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(final String errorMessage) {
        super(errorMessage);
    }
}
