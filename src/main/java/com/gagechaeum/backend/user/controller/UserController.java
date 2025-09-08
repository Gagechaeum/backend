package com.gagechaeum.backend.user.controller;

import com.gagechaeum.backend.common.response.CustomResponse;
import com.gagechaeum.backend.common.response.ResponseCode;
import com.gagechaeum.backend.global.exception.BusinessException;
import com.gagechaeum.backend.global.exception.ErrorCode;
import com.gagechaeum.backend.security.account.domain.CustomUserDetails;
import com.gagechaeum.backend.user.domain.User;
import com.gagechaeum.backend.user.dto.*;
import com.gagechaeum.backend.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/me")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/email-check")
    public ResponseEntity<CustomResponse<Void>> checkEmailDuplicate(@RequestParam String email) {
        //실패
        if (userService.isEmailDuplicated(email)) {
            throw new BusinessException(ErrorCode.USER_ALREADY_EXISTS);
        }
        // 성공
        return ResponseEntity
                .status(ResponseCode.EMAIL_AVAILABLE.getHttpStatus())
                .body(CustomResponse.success(ResponseCode.EMAIL_AVAILABLE));
    }

    @PostMapping("/signup")
    public ResponseEntity<CustomResponse<UserResponseDTO>> join(@RequestBody UserJoinRequestDTO request) {
        UserResponseDTO userResponse = userService.registerUser(request);
        return ResponseEntity
                .status(ResponseCode.SIGNUP_SUCCESS.getHttpStatus())
                .body(CustomResponse.success(ResponseCode.SIGNUP_SUCCESS, userResponse));
    }

    @PutMapping("/password-change")
    public ResponseEntity<CustomResponse<String>> changePassword(@AuthenticationPrincipal UserDetails userDetails, @RequestBody PasswordChangeDTO request) {
        String tempPassword = userService.changePassword(userDetails.getUsername(), request);
        return ResponseEntity
                .status(ResponseCode.PASSWORD_CHANGE_SUCCESS.getHttpStatus())
                .body(CustomResponse.success(ResponseCode.PASSWORD_CHANGE_SUCCESS, tempPassword));
    }

    @PutMapping("/password-reset")
    public ResponseEntity<CustomResponse<String>> resetPassword(@RequestBody UserEmailRequestDTO request) {
        String tempPassword = userService.resetPassword(request.getEmail());
        return ResponseEntity
                .status(ResponseCode.PASSWORD_RESET_SUCCESS.getHttpStatus())
                .body(CustomResponse.success(ResponseCode.PASSWORD_RESET_SUCCESS, tempPassword));
    }

    @PutMapping("/withdrawal")
    public ResponseEntity<CustomResponse<Void>> withdrawal(@RequestHeader("Authorization") String token) {
        userService.withdrawal(token);
        return ResponseEntity
                .status(ResponseCode.WITHDRAWAL_SUCCESS.getHttpStatus())
                .body(CustomResponse.success(ResponseCode.WITHDRAWAL_SUCCESS));
    }

    @GetMapping("/")
    public ResponseEntity<CustomResponse<Map<String, Object>>> me(@AuthenticationPrincipal CustomUserDetails userDetails) {
        Map<String, Object> body = new HashMap<>();
        body.put("id", userDetails.getUserId());
        body.put("email", userDetails.getUsername());
        // 💡 User VO에 role 필드가 없으므로 해당 라인 제거
        body.put("authorities", userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toArray(String[]::new));

        return ResponseEntity
                .status(ResponseCode.GET_MY_INFO_SUCCESS.getHttpStatus())
                .body(CustomResponse.success(ResponseCode.GET_MY_INFO_SUCCESS, body));
    }

    // 닉네임 존재여부 체크
    @GetMapping("/isNicknameExist")
    public ResponseEntity<CustomResponse<Void>> emailExist(@RequestParam String nickname) {
        userService.isNicknameExist(nickname);
        return ResponseEntity
                .status(ResponseCode.CAN_USE_NICKNAME.getHttpStatus())
                .body(CustomResponse.success(ResponseCode.CAN_USE_NICKNAME));
    }

    // --- 이메일 인증 관련 API ---
    @PostMapping("/email/verify/request")
    public ResponseEntity<CustomResponse<Void>> emailVerifyRequest(@RequestBody EmailVerificationRequestDTO dto) {
        userService.requestEmailVerification(dto.getEmail());
        return ResponseEntity
                .status(ResponseCode.EMAIL_VERIFICATION_REQUEST_SUCCESS.getHttpStatus())
                .body(CustomResponse.success(ResponseCode.EMAIL_VERIFICATION_REQUEST_SUCCESS));
    }

    @PostMapping("/email/verify/confirm")
    public ResponseEntity<CustomResponse<Void>> emailVerifyConfirm(@RequestBody EmailCodeConfirmDTO dto) {
        userService.confirmEmailVerification(dto.getEmail(), dto.getCode());
        return ResponseEntity
                .status(ResponseCode.EMAIL_VERIFICATION_CONFIRM_SUCCESS.getHttpStatus())
                .body(CustomResponse.success(ResponseCode.EMAIL_VERIFICATION_CONFIRM_SUCCESS));
    }

    @GetMapping("/email/verify/status")
    public ResponseEntity<CustomResponse<Boolean>> emailVerifyStatus(@RequestParam String email) {
        boolean isVerified = userService.isEmailVerifiedNow(email);
        return ResponseEntity
                .status(ResponseCode.EMAIL_VERIFICATION_STATUS_SUCCESS.getHttpStatus())
                .body(CustomResponse.success(ResponseCode.EMAIL_VERIFICATION_STATUS_SUCCESS, isVerified));
    }

    @PutMapping("/update/Notification")
    public ResponseEntity<CustomResponse<Void>> updateNotification(@AuthenticationPrincipal CustomUserDetails userDetails, @RequestBody Boolean notification) {
        userService.updateNotification(userDetails.getUserId(), notification);
        return ResponseEntity
                .status(ResponseCode.UPDATE_NOTIFICATION_SUCCESS.getHttpStatus())
                .body(CustomResponse.success(ResponseCode.UPDATE_NOTIFICATION_SUCCESS));
    }

    @PutMapping("/update/user")
    public ResponseEntity<CustomResponse<Void>> update(@AuthenticationPrincipal CustomUserDetails userDetails, @RequestBody UpdateUserDTO req) {
        userService.updateUser(userDetails.getUserId(), req);
        return ResponseEntity
                .status(ResponseCode.UPDATE_USER_SUCCESS.getHttpStatus())
                .body(CustomResponse.success(ResponseCode.UPDATE_USER_SUCCESS));
    }

    @GetMapping("/get/userInfo")
    public ResponseEntity<CustomResponse<Object>> getUserInfo(@AuthenticationPrincipal CustomUserDetails userDetails) {
        UserInfoResponseDTO res=userService.getUserInfo(userDetails);
        return ResponseEntity
                .status(ResponseCode.GET_USERINFO_SUCCESS.getHttpStatus())
                .body(CustomResponse.success(ResponseCode.GET_USERINFO_SUCCESS,res));
    }

    @PutMapping("/update/profile-image")
    public ResponseEntity<CustomResponse<Void>> updateProfileImage(
            @AuthenticationPrincipal CustomUserDetails userDetails,
            @RequestParam("image") MultipartFile image) {

        if (image == null || image.isEmpty()) {
            throw new BusinessException(ErrorCode.INVALID_INPUT_VALUE, "이미지 파일이 비어있습니다.");
        }

        userService.updateProfileImage(userDetails.getUserId(), image);

        return ResponseEntity
                .status(ResponseCode.UPDATE_USER_SUCCESS.getHttpStatus())
                .body(CustomResponse.success(ResponseCode.UPDATE_USER_SUCCESS));
    }


}