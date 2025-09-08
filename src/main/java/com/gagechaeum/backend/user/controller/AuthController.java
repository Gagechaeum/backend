package com.gagechaeum.backend.user.controller;

import com.gagechaeum.backend.common.response.CustomResponse;
import com.gagechaeum.backend.common.response.ResponseCode;
import com.gagechaeum.backend.global.exception.BusinessException;
import com.gagechaeum.backend.global.exception.ErrorCode;
import com.gagechaeum.backend.security.account.dto.UserLoginRequestDTO;
import com.gagechaeum.backend.security.util.CookieUtil;
import com.gagechaeum.backend.user.dto.TokenResponseDTO;
import com.gagechaeum.backend.user.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import com.gagechaeum.backend.common.redis.RedisService;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final RedisService redisService;

    @PostMapping("/test-login")
    public ResponseEntity<CustomResponse<TokenResponseDTO>> login(@RequestBody UserLoginRequestDTO request) {
        log.info("🛂 로그인 컨트롤러 진입");
        TokenResponseDTO token = userService.login(request);
        return ResponseEntity
                .status(ResponseCode.LOGIN_SUCCESS.getHttpStatus())
                .body(CustomResponse.success(ResponseCode.LOGIN_SUCCESS, token));
    }

    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "Cookie",
                    value = "refreshToken=<리프레시 토큰 값>",
                    required = true,
                    paramType = "header"
            )
    })

    @PostMapping("/refresh")
    public ResponseEntity<CustomResponse<Void>> refresh(
            @CookieValue(value = "refreshToken", required = false) String refreshToken,
            HttpServletResponse response
    ) {
        // 실패 시: BusinessException을 발생시켜 처리를 위임
        if (refreshToken == null || refreshToken.isBlank()) {
            throw new BusinessException(ErrorCode.JWT_TOKEN_INVALID, "리프레시 토큰이 존재하지 않습니다.");
        }

        TokenResponseDTO token = userService.refresh(refreshToken);

        response.setHeader("Authorization", "Bearer " + token.getAccessToken());
        CookieUtil.addHttpOnlyCookie(
                response, "refreshToken", token.getRefreshToken(),
                7 * 24 * 60 * 60, false, "Lax"
        );

        return ResponseEntity
                .status(ResponseCode.TOKEN_REISSUE_SUCCESS.getHttpStatus())
                .body(CustomResponse.success(ResponseCode.TOKEN_REISSUE_SUCCESS));
    }

    @PostMapping("/logout")
    public ResponseEntity<CustomResponse<Void>> logout(
            @RequestHeader("Authorization") String bearerToken,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        userService.logout(bearerToken);

        boolean isDev = request.getServerName().contains("localhost");
        String sameSite = isDev ? "Lax" : "None";
        boolean secure = !isDev;
        CookieUtil.deleteCookie(response, "refreshToken", secure, sameSite);

        return ResponseEntity
                .status(ResponseCode.LOGOUT_SUCCESS.getHttpStatus())
                .body(CustomResponse.success(ResponseCode.LOGOUT_SUCCESS));
    }

    @GetMapping("/test-redis")
    public String testToken(@RequestParam Long id) {
        return redisService.getRefreshToken(id);
    }

    @PostMapping("/login")
    public void swaggerLoginForDocs(@RequestBody UserLoginRequestDTO request) {
        throw new IllegalStateException("이 엔드포인트는 Swagger 문서화를 위한 것이며, 직접 호출할 수 없습니다.");
    }

}
