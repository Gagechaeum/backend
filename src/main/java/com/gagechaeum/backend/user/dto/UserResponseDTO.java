package com.gagechaeum.backend.user.dto;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class UserResponseDTO {
    private Long id;
    private String email;
    private String userName;
    private String createdAt;
    private String nickname;
    private String level;
}

