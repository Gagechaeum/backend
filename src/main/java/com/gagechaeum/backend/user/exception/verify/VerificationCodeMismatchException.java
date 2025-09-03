package com.gagechaeum.backend.user.exception.verify;

import com.gagechaeum.backend.global.exception.BusinessException;
import com.gagechaeum.backend.global.exception.ErrorCode;

public class VerificationCodeMismatchException extends BusinessException {
    public VerificationCodeMismatchException() {
        super(ErrorCode.VERIFICATION_CODE_MISMATCH);
    }
}