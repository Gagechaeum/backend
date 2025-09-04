package com.gagechaeum.backend.user.exception.verify;

import com.gagechaeum.backend.global.exception.BusinessException;
import com.gagechaeum.backend.global.exception.ErrorCode;

public class VerificationTokenNotFoundException extends BusinessException {
    public VerificationTokenNotFoundException() {
        super(ErrorCode.VERIFICATION_TOKEN_NOT_FOUND);
    }
}