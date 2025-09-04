package com.gagechaeum.backend.user.exception.auth;

import com.gagechaeum.backend.global.exception.BusinessException;
import com.gagechaeum.backend.global.exception.ErrorCode;

public class InvalidPasswordException extends BusinessException {
    public InvalidPasswordException() {
        super(ErrorCode.INVALID_PASSWORD);
    }
}