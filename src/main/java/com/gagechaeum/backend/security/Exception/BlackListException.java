package com.gagechaeum.backend.security.Exception;

import org.springframework.security.core.AuthenticationException;

public class BlackListException extends AuthenticationException {
    public BlackListException(String message) {
        super(message);
    }
}
