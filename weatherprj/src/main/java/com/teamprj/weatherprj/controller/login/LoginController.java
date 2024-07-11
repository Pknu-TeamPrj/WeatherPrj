package com.teamprj.weatherprj.controller.login;


import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;



@RestController
@RequestMapping(value = "/auth")
public class LoginController {

    @GetMapping("/naver/login/callback")
    public String naverLoginCallback(HttpServletRequest request){
        // 요청 URL
        String requestUrl = request.getRequestURL().toString();
        System.out.println("Request URL: " + requestUrl);

        // 요청 메서드 (GET, POST 등)
        String requestMethod = request.getMethod();
        System.out.println("Request Method: " + requestMethod);
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        System.out.println("Parameter code: " + code);
        System.out.println("Parameter state: " + state);
        return "naverLogin";
    }
}
