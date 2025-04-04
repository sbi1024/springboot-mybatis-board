package com.test.example.springbootmybatisboard.user.dao;

import com.test.example.springbootmybatisboard.user.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    int registerUser(UserDto userDto);
}
