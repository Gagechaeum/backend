package com.gagechaeum.backend.user.exception.signup;

import com.gagechaeum.backend.global.exception.BusinessException;
import com.gagechaeum.backend.global.exception.ErrorCode;

public class ValidationFailedException extends BusinessException {
    public ValidationFailedException() {
        super(ErrorCode.VALIDATION_FAILED);
    }
}