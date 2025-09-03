package com.gagechaeum.backend.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ResponseCode {

    //200 OK
    SUCCESS(HttpStatus.OK, "성공했습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
