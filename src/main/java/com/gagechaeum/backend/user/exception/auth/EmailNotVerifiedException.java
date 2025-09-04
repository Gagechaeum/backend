package com.gagechaeum.backend.user.exception.auth;

import com.gagechaeum.backend.global.exception.BusinessException;
import com.gagechaeum.backend.global.exception.ErrorCode;

public class EmailNotVerifiedException extends BusinessException {
    public EmailNotVerifiedException() {

        super(ErrorCode.EMAIL_NOT_VERIFIED);
    }
}