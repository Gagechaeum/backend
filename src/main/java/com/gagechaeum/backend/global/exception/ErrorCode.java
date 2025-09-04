package com.gagechaeum.backend.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import javax.net.ssl.HttpsURLConnection;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // Common
    INVALID_INPUT_VALUE("C001", "잘못된 입력값입니다.", HttpStatus.BAD_REQUEST),
    METHOD_NOT_ALLOWED("C002", "허용되지 않은 HTTP 메서드입니다.", HttpStatus.METHOD_NOT_ALLOWED),
    ENTITY_NOT_FOUND("C003", "요청한 데이터를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    INTERNAL_SERVER_ERROR("C004", "서버 내부 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_TYPE_VALUE("C005", "잘못된 타입입니다.", HttpStatus.BAD_REQUEST),
    ACCESS_DENIED("C006", "접근이 거부되었습니다.", HttpStatus.FORBIDDEN),

    // Authentication & Authorization
    AUTHENTICATION_FAILED("A001", "인증에 실패했습니다.", HttpStatus.UNAUTHORIZED),
    AUTHORIZATION_FAILED("A002", "권한이 없습니다.", HttpStatus.FORBIDDEN),
    JWT_TOKEN_INVALID("A003", "유효하지 않은 JWT 토큰입니다.", HttpStatus.UNAUTHORIZED),
    JWT_TOKEN_EXPIRED("A004", "만료된 JWT 토큰입니다.", HttpStatus.UNAUTHORIZED),
    EMAIL_NOT_VERIFIED("A005", "이메일 인증이 완료되지 않았습니다.", HttpStatus.FORBIDDEN),

    // User
    USER_NOT_FOUND("U001", "사용자를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    USER_ALREADY_EXISTS("U002", "이미 존재하는 사용자입니다.", HttpStatus.CONFLICT),
    INVALID_PASSWORD("U003", "비밀번호가 일치하지 않습니다.", HttpStatus.BAD_REQUEST),
    NICKNAME_ALREADY_EXISTS("U004", "이미 사용 중인 닉네임입니다.", HttpStatus.CONFLICT),

    // External API
    EXTERNAL_API_ERROR("E001", "외부 API 호출 중 오류가 발생했습니다.", HttpStatus.SERVICE_UNAVAILABLE),

    // Database
    DATABASE_ERROR("D001", "데이터베이스 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR),

    // Validation
    VALIDATION_FAILED("V001", "유효성 검사에 실패했습니다.", HttpStatus.BAD_REQUEST),
    VERIFICATION_TOKEN_NOT_FOUND("V002", "인증 토큰을 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    VERIFICATION_CODE_EXPIRED("V003", "인증 코드가 만료되었습니다.", HttpStatus.GONE), // 410 Gone
    VERIFICATION_CODE_MISMATCH("V004", "인증 코드가 일치하지 않습니다.", HttpStatus.BAD_REQUEST),
    VERIFICATION_RATE_LIMITED("V005", "요청 횟수를 초과했습니다. 잠시 후 다시 시도해주세요.", HttpStatus.TOO_MANY_REQUESTS), // 429 Too Many Requests
    EMAIL_ALREADY_VERIFIED("V006", "이미 인증된 이메일입니다.", HttpStatus.CONFLICT), // 409 Conflict
    VERIFICATION_TOKEN_INVALID("V007", "인증 토큰이 유효하지 않습니다.", HttpStatus.BAD_REQUEST),
    NEW_PASSWORD_INVALID("V008","새 비밀번호와 확인용 비밀번호가 일치하지 않습니다.", HttpStatus.BAD_REQUEST);

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;
}