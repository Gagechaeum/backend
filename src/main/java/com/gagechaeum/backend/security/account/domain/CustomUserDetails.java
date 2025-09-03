package com.gagechaeum.backend.security.account.domain;

import com.gagechaeum.backend.user.domain.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Getter
public class CustomUserDetails implements UserDetails {

    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    // ## 권한 정보 (수정 제안) ##
    // 현재는 'ROLE_USER'로 고정되어 있습니다.
    // 향후 User 객체에 role 필드가 추가되면, 그 값을 동적으로 읽어오도록 수정해야 합니다.
    // 예: return Collections.singleton(new SimpleGrantedAuthority("ROLE_" + user.getRole().toString()));
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    // ## 계정 상태 메서드 ##

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        // [중요] 기존 user.getDeletedAt() != null 논리는 반대로 되어 있어 수정했습니다.
        boolean isNotDeleted = user.getDeletedAt() == null;
        return isNotDeleted && user.getIsVerified();
    }
}