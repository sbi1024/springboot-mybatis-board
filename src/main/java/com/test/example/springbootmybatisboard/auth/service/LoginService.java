package com.test.example.springbootmybatisboard.auth.service;

import com.test.example.springbootmybatisboard.user.dto.UserDto;

import java.util.Optional;

public interface LoginService {
    Optional<UserDto> login(UserDto userDto);
}
