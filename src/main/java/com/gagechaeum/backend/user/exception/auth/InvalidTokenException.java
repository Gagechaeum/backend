package com.gagechaeum.backend.user.exception.auth;

import com.gagechaeum.backend.global.exception.BusinessException;
import com.gagechaeum.backend.global.exception.ErrorCode;

public class InvalidTokenException extends BusinessException {
    public InvalidTokenException() {
        super(ErrorCode.JWT_TOKEN_INVALID);
    }
}