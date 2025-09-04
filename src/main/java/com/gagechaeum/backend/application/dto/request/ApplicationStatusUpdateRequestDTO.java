package com.gagechaeum.backend.application.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ApplicationStatusUpdateRequestDTO {
    private String status; // "요건확인", "제출 준비" 등 새로운 상태 값
}
