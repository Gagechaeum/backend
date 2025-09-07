package com.gagechaeum.backend.user.dto;

import com.gagechaeum.backend.user.exception.signup.PasswordMismatchException;
import com.gagechaeum.backend.user.exception.signup.ValidationFailedException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserDTO {
    private String nickname;
    private String phone;
}
