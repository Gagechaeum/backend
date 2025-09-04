package com.gagechaeum.backend.security.account.dto;

import com.gagechaeum.backend.user.domain.User;


public record UserInfoDTO(
        String email,
        String name,
        String phone
) {
    public static UserInfoDTO from(User user) {
        return new UserInfoDTO(
                user.getEmail(),
                user.getName(),
                user.getPhone()
        );
    }
}