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


        if ("naver".equals(provider)) {
            Map<String, Object> response = (Map<String, Object>) attributes.get("response");
            socialId = (String) response.get("id");
            email = (String) response.get("email");
            name = (String) response.get("name");
        } else if ("google".equals(provider)) {
            socialId = (String) attributes.get("sub");
            email = (String) attributes.get("email");
            name = (String) attributes.get("name");
        } else {
            throw new OAuth2AuthenticationException("Unsupported provider: " + provider);
        }

        User user = saveOrUpdate(provider, socialId, email, name);

        return new CustomUserDetails(user, attributes);
    }

    private User saveOrUpdate(String provider, String socialId, String email, String name) {
        User user = userMapper.findBySocialId(provider, socialId);

        if (user != null) {
            user.setName(name);
            userMapper.updateSocial(user);
        } else {
            user = User.builder()
                    .email(email)
                    .name(name)
                    .social(provider)
                    .socialId(socialId)
                    .createdAt(LocalDateTime.now())
                    .password(UUID.randomUUID().toString())
                    .build();
            userMapper.save(user);
        }
        return user;
    }
}

