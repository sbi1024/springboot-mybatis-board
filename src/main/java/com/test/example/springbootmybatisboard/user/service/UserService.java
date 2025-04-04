package com.test.example.springbootmybatisboard.user.service;

import com.test.example.springbootmybatisboard.user.dto.UserDto;
import com.test.example.springbootmybatisboard.user.dto.UserResultDto;

public interface UserService {
    UserResultDto registerUser(UserDto userDto);
}
