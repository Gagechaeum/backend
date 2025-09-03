package com.gagechaeum.backend.user.service;

import com.gagechaeum.backend.security.account.dto.UserLoginRequestDTO;
import com.gagechaeum.backend.user.domain.User;
import com.gagechaeum.backend.user.dto.PasswordChangeDTO;
import com.gagechaeum.backend.user.dto.TokenResponseDTO;
import com.gagechaeum.backend.user.dto.UserJoinRequestDTO;
import com.gagechaeum.backend.user.dto.UserResponseDTO;;

public interface UserService {

    boolean isEmailDuplicated(String email);
    UserResponseDTO registerUser(UserJoinRequestDTO req);
    TokenResponseDTO login(UserLoginRequestDTO req);
    TokenResponseDTO refresh(String refreshToken);
    String resetPassword(String email);
    String changePassword(String email, PasswordChangeDTO pwdChangeDTO);
    void logout(String token);
    void withdrawal(String token);

    // 이메일 인증
    void requestEmailVerification(String email);
    void confirmEmailVerification(String email, String code);
    boolean isEmailVerifiedNow(String email);
}
