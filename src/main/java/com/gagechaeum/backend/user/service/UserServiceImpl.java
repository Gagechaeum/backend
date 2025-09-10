package com.gagechaeum.backend.user.service;

import com.gagechaeum.backend.common.mail.MailService;
import com.gagechaeum.backend.common.redis.RedisService;
import com.gagechaeum.backend.common.util.S3ClientUtil;
import com.gagechaeum.backend.global.exception.BusinessException;
import com.gagechaeum.backend.global.exception.ErrorCode;
import com.gagechaeum.backend.security.account.domain.CustomUserDetails;
import com.gagechaeum.backend.security.account.dto.UserLoginRequestDTO;
import com.gagechaeum.backend.security.util.JwtUtil;
import com.gagechaeum.backend.user.domain.User;
import com.gagechaeum.backend.user.dto.*;
import com.gagechaeum.backend.user.exception.auth.*;
import com.gagechaeum.backend.user.exception.signup.ValidationFailedException;
import com.gagechaeum.backend.user.exception.verify.EmailAlreadyVerifiedException;
import com.gagechaeum.backend.user.exception.verify.VerificationCodeExpiredException;
import com.gagechaeum.backend.user.exception.verify.VerificationCodeMismatchException;
import com.gagechaeum.backend.user.exception.verify.VerificationRateLimitException;
import com.gagechaeum.backend.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    private final JwtUtil jwtUtil;
    private final RedisService redisService;
    private final PasswordEncoder encoder;
    private final MailService mailService;
    private final S3ClientUtil s3ClientUtil;

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    // 이메일 인증 정책
    private static final int VERIFY_MAX_TRIES = 5;
    private static final int DAILY_LIMIT = 10;

    public boolean isEmailDuplicated(String email) {
        return userMapper.findByEmail(email) != null;
    }

    // ===== 이메일 인증 요청 =====
    @Override
    public void requestEmailVerification(String email) {
        // 이미 가입된 메일 검사
        if (userMapper.findByEmail(email) != null) {
            throw new EmailAlreadyVerifiedException();
        }
        // DB에서 이미 인증된 메일일 경우(기존 가입 이력) - 선택적으로 제한
        Boolean dbVerified = userMapper.selectIsVerifiedByEmail(email);
        if (Boolean.TRUE.equals(dbVerified)) {
            // 필요시 별도 예외로 막아도 되고, 그냥 코드 발송 허용도 가능
            // throw new EmailAlreadyVerifiedException();
        }

        // 일일 전송 제한
        long dailyCnt = redisService.incrDailyAndSetExpireIfNew(email);
        if (dailyCnt > DAILY_LIMIT) {
            throw new VerificationRateLimitException();
        }

        // 재전송 쿨타임
        if (redisService.hasEvCooldown(email)) {
            throw new VerificationRateLimitException();
        }

        // 6자리 코드 생성
        String code = org.apache.commons.lang3.RandomStringUtils.randomNumeric(6);

        // Redis 저장(코드/tries 초기화)
        redisService.saveEvCode(email, code);
        // 쿨타임 60초
        redisService.setEvCooldown(email);

        // 메일 발송
        mailService.sendVerificationCode(email, code);
    }

    // ===== 인증 코드 확인 =====
    @Override
    public void confirmEmailVerification(String email, String code) {
        String saved = redisService.getEvCode(email);
        if (saved == null) {
            throw new VerificationCodeExpiredException();
        }

        int tries = redisService.getEvTries(email);
        if (tries >= VERIFY_MAX_TRIES) {
            throw new VerificationRateLimitException();
        }

        if (!saved.equals(code)) {
            redisService.incEvTries(email);
            throw new VerificationCodeMismatchException();
        }

        // 성공: 가입 허용 플래그(30분) 세팅
        redisService.setEvOk(email);

        userMapper.updateIsVerifiedByEmail(email, true);

        // 사용한 코드/시도정보 정리
        redisService.clearEvCodeState(email);
    }

    // ===== 현재 인증여부 판단 (가입 전/후 공용) =====
    @Override
    public boolean isEmailVerifiedNow(String email) {
        if (redisService.hasEvOk(email)) return true;
        Boolean v = userMapper.selectIsVerifiedByEmail(email);
        return Boolean.TRUE.equals(v);
    }

    //닉네임 존재여부 체크
    @Override
    public void isNicknameExist(String nickname){
        Boolean aBoolean=userMapper.findIsNickname(nickname);
        if(aBoolean){
            throw new BusinessException(ErrorCode.USER_ALREADY_EXISTS);
        }
    }

    // ===== 회원가입 시 인증검사 + is_verified=true 저장 =====
    @Override
    public UserResponseDTO registerUser(UserJoinRequestDTO req) {
        log.info("회원가입 시도: {}", req.getEmail() + " , " + req.getPassword());

        req.validate();

        // 이메일 중복 검사
        if (userMapper.findByEmail(req.getEmail()) != null) {
            throw new EmailAlreadyVerifiedException();
        }
        // 닉네임 중복 검사
        isNicknameExist(req.getNickname());

        // 인증 완료 플래그 확인(필수)
        if (!isEmailVerifiedNow(req.getEmail())) {
            throw new EmailNotVerifiedException();
        }

        User user = req.toUser(); // DTO → 도메인 객체
        user.setPassword(encoder.encode(user.getPassword())); // 비밀번호 암호화
        user.setNotification(false);
        user.setProfileImageKey("userProfileImage/default.png");
        // 기본값 설정
        user.setIsVerified(true); // 가입 시 true로 저장
        user.setCreatedAt(LocalDateTime.now());


        // 저장
        try {
            userMapper.save(user);
        } catch (DuplicateKeyException e) {
            throw new EmailAlreadyVerifiedException();
        }

        // 가입 완료 후 ok 플래그 제거
        redisService.delete(redisService.evOkKey(req.getEmail()));

        return UserResponseDTO.builder()
                .id(user.getUserId())
                .email(user.getEmail())
                .userName(user.getName())
                .createdAt(user.getCreatedAt().toString())
                .build();
    }


    public TokenResponseDTO login(UserLoginRequestDTO req) {
        log.info("🔒 로그인 시도: {}", req.getEmail());
        User u = userMapper.findByEmail(req.getEmail());

        if (u == null) {
            throw new ValidationFailedException();
        }

        if (!encoder.matches(req.getPassword(), u.getPassword())) {
            throw new InvalidPasswordException();
        }

        // 계정이 활성화 상태인지 확인합니다.
        if (u.getDeletedAt() != null) {
            throw new DisabledException("비활성화된 계정입니다.");
        }


        String at = jwtUtil.generateAccessToken(u.getUserId(), u.getEmail());
        String rt = jwtUtil.generateRefreshToken(u.getUserId(), u.getEmail());
        redisService.saveRefreshToken(u.getUserId(), rt);
        return new TokenResponseDTO(at, rt);
    }


    public TokenResponseDTO refresh(String refreshToken) {
        log.info("🔒 토큰 재발급 시도: {}", refreshToken);
        if (!jwtUtil.validateToken(refreshToken))
            throw new InvalidTokenException();

        Long id = jwtUtil.getIdFromToken(refreshToken);
        String email = jwtUtil.getEmailFromToken(refreshToken);
        String saved = redisService.getRefreshToken(id);
        if (!refreshToken.equals(saved))
            throw new ExpiredTokenException();

        String at = jwtUtil.generateAccessToken(id, email);
        String rt = jwtUtil.generateRefreshToken(id, email);
        redisService.saveRefreshToken(id, rt);
        return new TokenResponseDTO(at, rt);
    }

    // 로그아웃 시, refreshToken 삭제 및 블랙리스트에 accessToken 추가
    public void logout(String bearerToken){

        if (bearerToken == null || !bearerToken.startsWith("Bearer ")) {
            log.warn("로그아웃 요청 실패: 유효하지 않은 토큰 형식");
            throw new InvalidTokenException();
        }
        log.info("로그아웃 시도: {}", bearerToken);

        //1. 토큰 검증
        if (bearerToken.startsWith("Bearer ")) {

            String token = bearerToken.substring("Bearer ".length());

            // 2. 토큰에서 사용자 ID 추출
            Long userId = jwtUtil.getIdFromToken(token);

            // 3. Redis에서 refreshToken 삭제 및 블랙리스트에 accessToken 추가
            redisService.deleteRefreshToken(userId);
            redisService.blacklistAccessToken(token);
            log.info("로그아웃 성공: {},{}", token, userId);
        }
    }

    public String resetPassword(String email) {
        log.info("🔒 비밀번호 재발급 시도: {}", email);
        User u = userMapper.findByEmail(email);
        if (u == null) throw new UserNotFoundException();
        String temp = UUID.randomUUID().toString().substring(0,8); // 임시 비밀번호 생성
        mailService.sendPasswordChanged(email, temp);
        u.setPassword(encoder.encode(temp)); // 암호화
        userMapper.updatePassword(u); // DB에 저장
        return temp;
    }

    @Override
    public String changePassword(String email, PasswordChangeDTO pwdChangeDTO) {
        // 사용자 정보 조회
        User user = userMapper.findByEmail(email);
        if (user == null) {
            throw new UserNotFoundException();
        }

        // 현재 비밀번호 일치 여부 확인
        if (!encoder.matches(pwdChangeDTO.getOldPassword(), user.getPassword())) {
            throw new InvalidPasswordException(); // "비밀번호가 일치하지 않습니다."
        }

        //비밀번호 양식에 맞는지 확인
        String pwRegex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_+=-]).{8,}$";
        if (!pwdChangeDTO.getNewPassword().matches(pwRegex)) {
            throw new ValidationFailedException();
        }

        // 새 비밀번호와 확인용 비밀번호가 일치하는지 확인
        if (!pwdChangeDTO.getNewPassword().equals(pwdChangeDTO.getConfirmPassword())) {
            throw new BusinessException(ErrorCode.NEW_PASSWORD_INVALID);
        }

        String encodedNewPassword = encoder.encode(pwdChangeDTO.getNewPassword());
        user.setPassword(encodedNewPassword);
        userMapper.updatePassword(user);

        log.info("✔️ 비밀번호 변경 완료: {}", email);

        return "비밀번호가 성공적으로 변경되었습니다.";
    }


    public void withdrawal(String bearerToken) {

        String token = bearerToken.substring("Bearer ".length());

        if (!jwtUtil.validateToken(token))
            throw new InvalidTokenException();

        Long id = jwtUtil.getIdFromToken(token);
        log.info("회원 탈퇴 시도: {}",id);

        userMapper.updateDeletedAt(id);
        redisService.deleteRefreshToken(id);
        redisService.blacklistAccessToken(token);
    }

    public void updateNotification(Long id, Boolean notification) {
        userMapper.updateNotification(id, notification);

        log.info("알림여부 변경완료 : {}", notification);
    }

    public void updateUser(CustomUserDetails userDetails, UpdateUserDTO req) {

        String oldNickname=userDetails.getNickname();

        if (!oldNickname.equals(req.getNickname())) {
            isNicknameExist(req.getNickname());
        }

        userMapper.updateUser(userDetails.getUserId(), req);
        log.info("유저정보 변경완료 : {}", req.toString());
    }

    public UserInfoResponseDTO getUserInfo(CustomUserDetails user) {
        String profileImageKey = userMapper.findProfileImageKeyById(user.getUserId());
        String  profileImageUrl= null;

        if (profileImageKey != null && !profileImageKey.isEmpty()) {
            // S3 키를 사용해 임시 접근 URL을 생성합니다.
            profileImageUrl = s3ClientUtil.getProfileUrl(profileImageKey);
        }

        return UserInfoResponseDTO.builder()
                .userId(user.getUserId())
                .name(user.getTrueName())
                .phone(user.getPhone())
                .email(user.getUsername())
                .nickname(user.getNickname())
                .profileImageKey(profileImageUrl)
                .build();
    }

    @Override
    public void updateProfileImage(Long userId, MultipartFile profileImage) {
        // 기존 이미지 키 조회
        String oldImageKey = userMapper.findProfileImageKeyById(userId);

        // 확장자 추출 후, 새 이미지 키 생성
        String extension = getFileExtension(profileImage.getOriginalFilename());
        String newImageKey = "userProfileImage/" + userId + "_" + UUID.randomUUID().toString() + extension;

        try {
            // S3에 새 이미지 업로드
            s3ClientUtil.uploadProfile(profileImage, newImageKey);
        } catch (IOException e) {
            log.error("S3 파일 업로드 실패: {}", e.getMessage());
            throw new BusinessException(ErrorCode.FILE_UPLOAD_FAILED);
        }

        // DB에 새 이미지 키 업데이트
        userMapper.updateProfileImageKey(userId, newImageKey);
        log.info("사용자 {} 프로필 이미지 키 업데이트 완료: {}", userId, newImageKey);

        // 기존 이미지가 있었다면 S3에서 삭제
        if (StringUtils.hasText(oldImageKey) && !oldImageKey.equals("userProfileImage/default.png")) {
            s3ClientUtil.deleteFile(oldImageKey);
            log.info("기존 프로필 이미지 삭제 완료: {}", oldImageKey);
        }
    }

    // 확장자 추출 메소드
    private String getFileExtension(String filename) {
        if (StringUtils.hasText(filename) && filename.contains(".")) {
            return filename.substring(filename.lastIndexOf("."));
        }
        return "";
    }

    public Boolean passwordVerify(CustomUserDetails userDetails, String password) {
        if (userDetails == null) {
            throw new UserNotFoundException();
        }

        return encoder.matches(password, userDetails.getPassword());
    }
}