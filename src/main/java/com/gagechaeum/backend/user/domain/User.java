package com.gagechaeum.backend.user.domain;

import lombok.Getter;
import java.time.LocalDateTime;

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
}
