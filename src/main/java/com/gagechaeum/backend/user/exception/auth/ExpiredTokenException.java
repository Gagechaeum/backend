package com.gagechaeum.backend.user.exception.auth;

import com.gagechaeum.backend.global.exception.BusinessException;
import com.gagechaeum.backend.global.exception.ErrorCode;

public class ExpiredTokenException extends BusinessException {
    public ExpiredTokenException() {
        super(ErrorCode.JWT_TOKEN_EXPIRED);
    }
}