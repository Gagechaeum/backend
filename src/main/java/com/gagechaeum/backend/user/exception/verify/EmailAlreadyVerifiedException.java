package com.gagechaeum.backend.user.exception.verify;

import com.gagechaeum.backend.global.exception.BusinessException;
import com.gagechaeum.backend.global.exception.ErrorCode;

public class EmailAlreadyVerifiedException extends BusinessException {
    public EmailAlreadyVerifiedException() {
        super(ErrorCode.EMAIL_ALREADY_VERIFIED);
    }
}