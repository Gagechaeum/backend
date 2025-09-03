package com.gagechaeum.backend.user.domain;

import lombok.Data;
import lombok.Getter;
import java.time.LocalDateTime;

@Data
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
