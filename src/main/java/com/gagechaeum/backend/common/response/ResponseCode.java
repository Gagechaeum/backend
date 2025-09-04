package com.gagechaeum.backend.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ResponseCode {

    // --- User 관련 성공 코드 ---
    SIGNUP_SUCCESS(HttpStatus.CREATED, "회원가입에 성공했습니다."),
    EMAIL_AVAILABLE(HttpStatus.OK, "사용 가능한 이메일입니다."),
    PASSWORD_RESET_SUCCESS(HttpStatus.OK, "임시 비밀번호가 발급되었습니다."),
    WITHDRAWAL_SUCCESS(HttpStatus.OK, "회원 탈퇴가 완료되었습니다."),
    GET_MY_INFO_SUCCESS(HttpStatus.OK, "내 정보 조회에 성공했습니다."),
    LOGIN_SUCCESS(HttpStatus.OK,"로그인에 성공했습니다"),
    PASSWORD_CHANGE_SUCCESS(HttpStatus.OK, "비밀번호 변경에 성공했습니다."),

    // --- 이메일 인증 관련 성공 코드 ---
    EMAIL_VERIFICATION_REQUEST_SUCCESS(HttpStatus.OK, "인증 코드가 이메일로 발송되었습니다."),
    EMAIL_VERIFICATION_CONFIRM_SUCCESS(HttpStatus.OK, "이메일 인증이 완료되었습니다."),
    EMAIL_VERIFICATION_STATUS_SUCCESS(HttpStatus.OK, "이메일 인증 상태 확인에 성공했습니다."),
    TOKEN_REISSUE_SUCCESS(HttpStatus.OK,"토큰 재발급에 성공했습니다." ),
    LOGOUT_SUCCESS(HttpStatus.OK,"로그아웃에 성공했습니다." ),
    CAN_USE_NICKNAME(HttpStatus.OK,"사용가능한 닉네임입니다."),

    //200 OK
    SUCCESS(HttpStatus.OK, "성공했습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
