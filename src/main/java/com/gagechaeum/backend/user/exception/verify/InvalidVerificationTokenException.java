package com.gagechaeum.backend.user.exception.verify;

import com.gagechaeum.backend.global.exception.BusinessException;
import com.gagechaeum.backend.global.exception.ErrorCode;

public class InvalidVerificationTokenException extends BusinessException {
    public InvalidVerificationTokenException() {
        super(ErrorCode.VERIFICATION_TOKEN_INVALID);
    }
}