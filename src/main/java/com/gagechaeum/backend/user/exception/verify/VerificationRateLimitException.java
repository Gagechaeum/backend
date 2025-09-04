package com.gagechaeum.backend.user.exception.verify;

import com.gagechaeum.backend.global.exception.BusinessException;
import com.gagechaeum.backend.global.exception.ErrorCode;

public class VerificationRateLimitException extends BusinessException {
    public VerificationRateLimitException() {
        super(ErrorCode.VERIFICATION_RATE_LIMITED);
    }
}