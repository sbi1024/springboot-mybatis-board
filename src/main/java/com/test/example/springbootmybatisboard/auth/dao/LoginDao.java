package com.test.example.springbootmybatisboard.auth.dao;

import com.test.example.springbootmybatisboard.user.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {
    UserDto login(String userEmail);
}
