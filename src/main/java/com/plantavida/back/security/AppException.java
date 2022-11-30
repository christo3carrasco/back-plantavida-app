package com.plantavida.back.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

public class AppException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    @Setter
    @Getter
    private HttpStatus status;

    @Setter
    @Getter
    private String message;

    public AppException(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

    public AppException(HttpStatus status, String message, String message1) {
        super();
        this.status = status;
        this.message = message;
        this.message = message1;
    }
}
