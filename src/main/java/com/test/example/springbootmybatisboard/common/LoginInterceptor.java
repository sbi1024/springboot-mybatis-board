package com.test.example.springbootmybatisboard.common;

import com.test.example.springbootmybatisboard.user.dto.UserDto;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    private final String jsonStr = "{\"result\":\"login\"}";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler ) throws Exception {
        System.out.println("LoginInterceptor >>>> " + request.getRequestURI());	// 로그용.

        // session에서 "login" 화면을 통해서 return true/false 처리
        HttpSession session = request.getSession();
        UserDto userDto = (UserDto) session.getAttribute("userDto");

        if(userDto == null) {
            // ajax 요청
            // client가 header에 "ajax":"true" <= board.jsp 라면 ajax 요청이라고 판단. 클라이언트가 서버에 자신이 ajax 요청임을 알려주는 약속.
            // {"result" : "login"} json 문자열 응답 => result: login이면 클라이언트에서 로그인 안되어있음을 판단. js에서 적절한 처리할것임.
            // client의 js에서 window.location.href 이용해서 페이지 이동
            if("true".equals(request.getHeader("ajax"))) {
                System.out.println("LoginInterceptor >>>> ajax request");
                response.getWriter().write(jsonStr);
            }
            // page 요청
            // -> 로그인 페이지로 이동(:redirect)
            else {
                System.out.println("LoginInterceptor >>>> page request");
                response.sendRedirect("/pages/login");
            }
            return false;
        }
        return true;
    }

}
