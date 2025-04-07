package com.test.example.springbootmybatisboard.auth.controller;

import com.test.example.springbootmybatisboard.auth.service.LoginService;
import com.test.example.springbootmybatisboard.user.dto.UserDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/auth")
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    @PostMapping("/login")
    @ResponseBody
    public Map<String, String> login(UserDto userDto, HttpSession session) {
        HashMap<String, String> map = new HashMap<>();

        Optional<UserDto> optional = loginService.login(userDto);

        System.out.println(optional.get());
        if (optional.isPresent()) {
            UserDto dto = optional.get();
            session.setAttribute("userDto", dto);
            map.put("result", "success");
            return map;
        }

        map.put("result", "fail");
        return map;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        System.out.println(session.getAttribute("userDto"));
        session.invalidate();
        return "login";
    }
}
