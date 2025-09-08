package com.gagechaeum.backend.user.exception.bis;

import com.gagechaeum.backend.global.exception.BusinessException;
import com.gagechaeum.backend.global.exception.ErrorCode;
import com.gagechaeum.backend.user.dto.VerifyBisResDTO;

public class BusinessValidationException extends BusinessException {
    // 기본 생성자 (기본 오류 코드를 사용)
    public BusinessValidationException() {
        super(ErrorCode.BUSINESS_VALIDATION_FAILED);
    }


    public BusinessValidationException(String message) {
        super(ErrorCode.BUSINESS_VALIDATION_FAILED, message);
    }


    public BusinessValidationException(ErrorCode errorCode) {
        super(errorCode);
    }

    public BusinessValidationException(ErrorCode errorCode, VerifyBisResDTO body) {
        super(errorCode, String.valueOf(body));
    }
}
