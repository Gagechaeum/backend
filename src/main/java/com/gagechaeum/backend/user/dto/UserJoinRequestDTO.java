package com.gagechaeum.backend.user.dto;

import com.gagechaeum.backend.user.domain.User;
import com.gagechaeum.backend.user.exception.signup.PasswordMismatchException;
import com.gagechaeum.backend.user.exception.signup.ValidationFailedException;
import lombok.Data;


@Data
public class UserJoinRequestDTO {
    private String email;
    private String password;
    private String passwordConfirm;
    private String name;
    private String nickname;
    private String phone;
    private String profileImageKey;

    public void validate() {
        // 이메일 형식 검사
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!email.matches(emailRegex)) {
            throw new ValidationFailedException();
        }

        // 비밀번호 확인
        if (!password.equals(passwordConfirm)) {
            throw new PasswordMismatchException();
        }

        // 비밀번호 형식 검사
        String pwRegex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_+=-]).{8,}$";
        if (!password.matches(pwRegex)) {
            throw new ValidationFailedException();
        }
    }

    // User로 변환
    public User toUser() {
        User user = new User();
        user.setEmail(this.email);
        user.setPassword(this.password); // 비밀번호 암호화는 Service에서 처리
        user.setNickname(this.nickname);
        user.setName(this.name);
        user.setPhone(this.phone);
        user.setProfileImageKey(this.profileImageKey);
        return user;
    }
}
