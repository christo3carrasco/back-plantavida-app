package com.plantavida.back.security;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class AppException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    @Getter
    private final HttpStatus status;

    @Getter
    private final String message;

    public AppException(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
    }
}
