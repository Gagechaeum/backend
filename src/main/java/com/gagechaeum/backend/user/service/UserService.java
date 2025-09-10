package com.gagechaeum.backend.user.service;

import com.gagechaeum.backend.security.account.domain.CustomUserDetails;
import com.gagechaeum.backend.security.account.dto.UserLoginRequestDTO;
import com.gagechaeum.backend.user.dto.*;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    boolean isEmailDuplicated(String email);

    void isNicknameExist(String nickname);

    UserResponseDTO registerUser(UserJoinRequestDTO req);
    TokenResponseDTO login(UserLoginRequestDTO req);
    TokenResponseDTO refresh(String refreshToken);
    String resetPassword(String email);
    String changePassword(String email, PasswordChangeDTO pwdChangeDTO);
    void logout(String token);
    void withdrawal(String token);
    void updateNotification(Long id, Boolean notification);
    void updateUser(CustomUserDetails userDetails, UpdateUserDTO req);
    UserInfoResponseDTO getUserInfo(CustomUserDetails user);
    Boolean passwordVerify(CustomUserDetails user, String password);

    // 이메일 인증
    void requestEmailVerification(String email);
    void confirmEmailVerification(String email, String code);
    boolean isEmailVerifiedNow(String email);

    void updateProfileImage(Long userId, MultipartFile profileImage);
}
