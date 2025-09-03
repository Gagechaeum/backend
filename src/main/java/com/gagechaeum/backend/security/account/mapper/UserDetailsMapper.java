package com.gagechaeum.backend.security.account.mapper;


import com.gagechaeum.backend.user.domain.User;

public interface UserDetailsMapper {
    User get(String email); // 이메일로 유저를 찾음
}
