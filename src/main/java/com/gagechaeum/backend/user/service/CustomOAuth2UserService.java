package com.gagechaeum.backend.user.service;

import com.gagechaeum.backend.security.account.domain.CustomUserDetails;
import com.gagechaeum.backend.user.domain.User;
import com.gagechaeum.backend.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserMapper userMapper;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        String provider = userRequest.getClientRegistration().getRegistrationId();

        Map<String, Object> attributes = oAuth2User.getAttributes();
        String socialId;
        String email;
        String name;
        String nickname;
        String profileImageKey;
        String phone;

        if ("naver".equals(provider)) {
            Map<String, Object> response = (Map<String, Object>) attributes.get("response");
            socialId = (String) response.get("id");
            email = (String) response.get("email");
            name = (String) response.get("name");
            phone = (String) response.get("mobile");
            profileImageKey = (String) response.get("profileImage");
            nickname = (String) response.get("nickname");

        }else {
            throw new OAuth2AuthenticationException("지원하지 않는 provider입니다: " + provider);
        }

        User user = saveOrUpdate(provider, socialId, email, name, nickname,profileImageKey,phone);

        return new CustomUserDetails(user, attributes);
    }

    private User saveOrUpdate(String provider
            ,String socialId
            ,String email
            ,String name
            ,String nickname
            ,String profileImageKey
            ,String phone) {

        User user = userMapper.findBySocialId(provider, socialId);

        if (user != null) {
            // email은 일반적으로 변경되지 않으므로 업데이트에서 제외할 수 있습니다.
            userMapper.updateSocial(name,socialId);

        } else {
            user = User.builder()
                    .email(email)
                    .name(name)
                    .nickname(nickname)
                    .phone(phone)
                    .profileImageKey(profileImageKey)
                    .social(provider)
                    .socialId(socialId)
                    .createdAt(LocalDateTime.now())
                    .password(UUID.randomUUID().toString()) // 소셜 로그인이므로 실제 비밀번호는 불필요
                    .notification(false)
                    .isVerified(true)
                    .build();
            userMapper.save(user);
        }
        return user;
    }
}

