package com.gagechaeum.backend.user.exception.verify;

import com.gagechaeum.backend.global.exception.BusinessException;
import com.gagechaeum.backend.global.exception.ErrorCode;

public class VerificationCodeExpiredException extends BusinessException {
    public VerificationCodeExpiredException() {
        super(ErrorCode.VERIFICATION_CODE_EXPIRED);
    }
}