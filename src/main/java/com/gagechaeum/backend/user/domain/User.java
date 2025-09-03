package com.gagechaeum.backend.user.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Setter
@Getter
public class User {
    private Long userId;
    private String email;
    private String password;
    private String nick;
    private String name;
    private String phone;
    private LocalDateTime createdAt;
    private String social;
    private String socialId;
    private LocalDateTime deletedAt;
    private Boolean isVerified;
}
