package com.gagechaeum.backend.security.handler;

import com.gagechaeum.backend.common.redis.RedisService;
import com.gagechaeum.backend.common.response.CustomResponse;
import com.gagechaeum.backend.security.account.domain.CustomUserDetails;
import com.gagechaeum.backend.security.account.dto.AuthResultDTO;
import com.gagechaeum.backend.security.account.dto.UserInfoDTO;
import com.gagechaeum.backend.security.util.CookieUtil;
import com.gagechaeum.backend.security.util.JsonResponse;
import com.gagechaeum.backend.security.util.JwtUtil;
import com.gagechaeum.backend.common.response.ResponseCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private final JwtUtil jwtUtil;
    private final RedisService redisService;

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) throws IOException {

        // 1) 사용자 정보
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        Long userId = userDetails.getUser().getUserId();
        String email = userDetails.getUsername();

        // 2) 토큰 생성
        String accessToken = jwtUtil.generateAccessToken(userId, email);
        String refreshToken = jwtUtil.generateRefreshToken(userId, email);

        // 3) RT Redis 저장
        try {
            redisService.saveRefreshToken(userId, refreshToken);
            log.info("✅ Redis 저장 성공: {} → {}", userId, refreshToken);
        } catch (Exception e) {
            log.error("❌ Redis 저장 실패: {}", e.getMessage());
        }

        // 4) RT를 httpOnly 쿠키로 발급 (HTTP + same-site 환경)
        //    Vite 프록시/운영 Nginx 프록시로 동일 오리진처럼 보이므로 Lax/secure=false 사용
        CookieUtil.addHttpOnlyCookie(
                response,
                "refreshToken",
                refreshToken,
                7 * 24 * 60 * 60,   // Max-Age = 7일
                false,              // Secure=false (HTTP)
                "Lax"               // SameSite=Lax
        );

        // 5) AT는 응답 헤더로 전달 (FE가 헤더에서 읽어 저장)
        response.setHeader("Authorization", "Bearer " + accessToken);

        // 6) 응답 바디(토큰은 포함하지 않음)
        UserInfoDTO userInfo = UserInfoDTO.from(userDetails.getUser());

        AuthResultDTO result = new AuthResultDTO    (
                null,               // accessToken 바디 미포함
                null,               // refreshToken 바디 미포함
                userInfo
        );

        CustomResponse<AuthResultDTO> body =
                CustomResponse.success(ResponseCode.LOGIN_SUCCESS, result);

        JsonResponse.send(response, body);
    }
}
