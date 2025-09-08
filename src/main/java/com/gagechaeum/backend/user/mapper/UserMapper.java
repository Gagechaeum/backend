package com.gagechaeum.backend.user.mapper;

import com.gagechaeum.backend.user.domain.User;
import com.gagechaeum.backend.user.dto.UpdateUserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserMapper {

    void save(User user); // 회원가입
    User findByEmail(String email); // 이메일로 비밀번호 찾기
    String findNicknameById(Long id);
    void updatePassword(User user); // 비밀번호 재발급
    void resetPassword(User user);
    void updateDeletedAt(Long id);
    Boolean findIsNickname(String nickname);
    void updateNotification(@Param("id") Long id, @Param("notification") Boolean notification); //알림설정상태 업데이트
    void updateUser(@Param("id") Long id, @Param("req")UpdateUserDTO req);

    // 이메일 인증
    void updateIsVerifiedByEmail(@Param("email") String email, @Param("isVerified") boolean isVerified);
    Boolean selectIsVerifiedByEmail(@Param("email") String email);

    // Oauth관련
    User findBySocialId(@Param("social") String social, @Param("socialId") String socialId);
    void updateSocial(@Param("name") String name, @Param("socialId") String socialId);
}
