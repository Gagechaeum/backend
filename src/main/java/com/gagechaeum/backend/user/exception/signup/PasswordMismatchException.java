package com.gagechaeum.backend.user.exception.signup;

import com.gagechaeum.backend.global.exception.BusinessException;
import com.gagechaeum.backend.global.exception.ErrorCode;

public class PasswordMismatchException extends BusinessException {
    public PasswordMismatchException() {
        super(ErrorCode.INVALID_PASSWORD);
    }
}