package com.test.example.springbootmybatisboard.auth.service;

import com.test.example.springbootmybatisboard.auth.dao.LoginDao;
import com.test.example.springbootmybatisboard.user.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {
    private final LoginDao loginDao;

    public LoginServiceImpl(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    @Override
    public Optional<UserDto> login(UserDto userDto) {
        UserDto dto = loginDao.login(userDto.getUserEmail());
        if (dto != null && userDto.getUserPassword().equals(dto.getUserPassword())) {
            return Optional.of(dto);
        }
        return Optional.empty();
    }
}
