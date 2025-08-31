package com.gagechaeum.backend.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CustomResponse<T> {

    private final int status;
    private final boolean isSuccess;
    private final String name;
    private final String message;
    private final T data;

    public static <T> CustomResponse<T> success(ResponseCode code, T data) {
        return new CustomResponse<>(code.getHttpStatus().value(), true, code.name(), code.getMessage(), data);
    }

    public static <T> CustomResponse<T> success(ResponseCode code) {
        return new CustomResponse<>(code.getHttpStatus().value(), true, code.name(), code.getMessage(), null);
    }

    public static <T> CustomResponse<T> error(ResponseCode code, T data) {
        return new CustomResponse<>(code.getHttpStatus().value(), false, code.name(), code.getMessage(), data);
    }

    public static <T> CustomResponse<T> error(ResponseCode code) {
        return new CustomResponse<>(code.getHttpStatus().value(), false, code.name(), code.getMessage(), null);
    }
}
