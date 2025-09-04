package com.gagechaeum.backend.user.domain;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class User {
    private Long userId;
    private String email;
    private String password;
    private String nickname;
    private String name;
    private String phone;
    private LocalDateTime createdAt;
    private String social;
    private String socialId;
    private LocalDateTime deletedAt;
    private Boolean isVerified;
    private String profileImageKey;
    private Boolean notification;
}
