package com.gagechaeum.backend.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ResponseCode {
    SUCCESS(HttpStatus.OK, "요청에 성공했습니다."),
    SUCCESS_CREATE(HttpStatus.CREATED, "생성에 성공했습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
