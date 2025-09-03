package com.gagechaeum.backend.user.service;

import com.gagechaeum.backend.common.mail.MailService;
import com.gagechaeum.backend.common.redis.RedisService;
import com.gagechaeum.backend.global.exception.BusinessException;
import com.gagechaeum.backend.global.exception.ErrorCode;
import com.gagechaeum.backend.security.account.dto.UserLoginRequestDTO;
import com.gagechaeum.backend.security.util.JwtUtil;
import com.gagechaeum.backend.user.domain.User;
import com.gagechaeum.backend.user.dto.TokenResponseDTO;
import com.gagechaeum.backend.user.dto.UserJoinRequestDTO;
import com.gagechaeum.backend.user.dto.UserResponseDTO;
import com.gagechaeum.backend.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final JwtUtil jwtUtil;
    private final RedisService redisService;
    private final PasswordEncoder encoder;
    private final MailService mailService;

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private static final int VERIFY_MAX_TRIES = 5;
    private static final int DAILY_LIMIT = 10;

    public boolean isEmailDuplicated(String email) {
        return userMapper.findByEmail(email) != null;
    }

    @Override
    public void requestEmailVerification(String email) {
        if (userMapper.findByEmail(email) != null) {
            throw new BusinessException(ErrorCode.USER_ALREADY_EXISTS);
        }
        Boolean dbVerified = userMapper.selectIsVerifiedByEmail(email);
        if (Boolean.TRUE.equals(dbVerified)) {
            throw new BusinessException(ErrorCode.EMAIL_ALREADY_VERIFIED);
        }

        long dailyCnt = redisService.incrDailyAndSetExpireIfNew(email);
        if (dailyCnt > DAILY_LIMIT) {
            throw new BusinessException(ErrorCode.VERIFICATION_RATE_LIMITED);
        }

        if (redisService.hasEvCooldown(email)) {
            throw new BusinessException(ErrorCode.VERIFICATION_RATE_LIMITED);
        }

        String code = org.apache.commons.lang3.RandomStringUtils.randomNumeric(6);
        redisService.saveEvCode(email, code);
        redisService.setEvCooldown(email);
        mailService.sendVerificationCode(email, code);
    }

    @Override
    public void confirmEmailVerification(String email, String code) {
        String saved = redisService.getEvCode(email);
        if (saved == null) {
            throw new BusinessException(ErrorCode.VERIFICATION_CODE_EXPIRED);
        }

        int tries = redisService.getEvTries(email);
        if (tries >= VERIFY_MAX_TRIES) {
            throw new BusinessException(ErrorCode.VERIFICATION_RATE_LIMITED);
        }

        if (!saved.equals(code)) {
            redisService.incEvTries(email);
            throw new BusinessException(ErrorCode.VERIFICATION_CODE_MISMATCH);
        }

        redisService.setEvOk(email);
        userMapper.updateIsVerifiedByEmail(email, true);
        redisService.clearEvCodeState(email);
    }

    @Override
    public boolean isEmailVerifiedNow(String email) {
        if (redisService.hasEvOk(email)) return true;
        Boolean v = userMapper.selectIsVerifiedByEmail(email);
        return Boolean.TRUE.equals(v);
    }

    @Override
    public UserResponseDTO registerUser(UserJoinRequestDTO req) {
        log.info("🔒 회원가입 시도: {}", req.getEmail());

        if (userMapper.findByEmail(req.getEmail()) != null) {
            throw new BusinessException(ErrorCode.USER_ALREADY_EXISTS);
        }

        if (!isEmailVerifiedNow(req.getEmail())) {
            throw new BusinessException(ErrorCode.EMAIL_NOT_VERIFIED);
        }

        User user = req.toUser();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setIsVerified(true);
        user.setIsActive(true);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        user.setLastPwChangeAt(LocalDateTime.now());
        user.setRole(org.scoula.user.enums.UserRole.USER);

        try {
            userMapper.save(user);
        } catch (DuplicateKeyException e) {
            throw new BusinessException(ErrorCode.USER_ALREADY_EXISTS);
        }

        redisService.delete(redisService.evOkKey(req.getEmail()));

        return UserResponseDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .userName(user.getUserName())
                .createdAt(user.getCreatedAt().toString())
                .nickname(req.getNickname()) // 수정된 부분
                .build();
    }

    public TokenResponseDTO login(UserLoginRequestDTO req) {
        log.info("🔒 로그인 시도: {}", req.getEmail());
        User u = userMapper.findByEmail(req.getEmail());

        if (u == null) {
            throw new BusinessException(ErrorCode.USER_NOT_FOUND);
        }

        if (!encoder.matches(req.getPassword(), u.getPassword())) {
            throw new BusinessException(ErrorCode.INVALID_PASSWORD);
        }

        if (!u.getIsActive()) {
            throw new BusinessException(ErrorCode.USER_ACCOUNT_DISABLED);
        }

        String at = jwtUtil.generateAccessToken(u.getId(), u.getEmail());
        String rt = jwtUtil.generateRefreshToken(u.getId(), u.getEmail());
        redisService.saveRefreshToken(u.getId(), rt);
        return new TokenResponseDTO(at, rt);
    }

    public TokenResponseDTO refresh(String refreshToken) {
        log.info("🔒 토큰 재발급 시도: {}", refreshToken);
        if (!jwtUtil.validateToken(refreshToken)) {
            throw new BusinessException(ErrorCode.JWT_TOKEN_INVALID);
        }

        Long id = jwtUtil.getIdFromToken(refreshToken);
        String email = jwtUtil.getEmailFromToken(refreshToken);
        String saved = redisService.getRefreshToken(id);
        if (!refreshToken.equals(saved)) {
            throw new BusinessException(ErrorCode.JWT_TOKEN_INVALID); // 재사용된 리프레시 토큰은 유효하지 않은 것으로 간주
        }

        String at = jwtUtil.generateAccessToken(id, email);
        String rt = jwtUtil.generateRefreshToken(id, email);
        redisService.saveRefreshToken(id, rt);
        return new TokenResponseDTO(at, rt);
    }

    public void logout(String bearerToken) {
        if (bearerToken == null || !bearerToken.startsWith("Bearer ")) {
            log.warn("로그아웃 요청 실패: 유효하지 않은 토큰 형식");
            throw new BusinessException(ErrorCode.JWT_TOKEN_INVALID);
        }
        log.info("로그아웃 시도: {}", bearerToken);

        String token = bearerToken.substring("Bearer ".length());
        Long userId = jwtUtil.getIdFromToken(token);

        redisService.deleteRefreshToken(userId);
        redisService.blacklistAccessToken(token);
        log.info("로그아웃 성공: 사용자 ID {}", userId);
    }

    public String resetPassword(String email) {
        log.info("🔒 비밀번호 재발급 시도: {}", email);
        User u = userMapper.findByEmail(email);
        if (u == null) {
            throw new BusinessException(ErrorCode.USER_NOT_FOUND);
        }
        String temp = UUID.randomUUID().toString().substring(0, 8);
        u.setPassword(encoder.encode(temp));
        userMapper.updatePassword(u);
        return temp;
    }

    public void withdrawal(String bearerToken) {
        String token = bearerToken.substring("Bearer ".length());

        if (!jwtUtil.validateToken(token)) {
            throw new BusinessException(ErrorCode.JWT_TOKEN_INVALID);
        }

        Long id = jwtUtil.getIdFromToken(token);
        log.info("회원 탈퇴 시도: 사용자 ID {}", id);

        userMapper.updateIsActive(id);
        redisService.deleteRefreshToken(id);
        redisService.blacklistAccessToken(token);
    }
}