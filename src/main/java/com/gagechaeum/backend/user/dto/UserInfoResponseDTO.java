package com.gagechaeum.backend.user.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfoResponseDTO {
    private Long userId;
    private String phone;
    private String nickname;
    private String email;
}
