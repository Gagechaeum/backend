package com.gagechaeum.backend.user.exception.auth;

import com.gagechaeum.backend.global.exception.BusinessException;
import com.gagechaeum.backend.global.exception.ErrorCode;

public class EmailNotFoundException extends BusinessException {

    public EmailNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}