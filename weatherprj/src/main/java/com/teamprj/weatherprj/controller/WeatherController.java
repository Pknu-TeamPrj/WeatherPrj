package com.teamprj.weatherprj.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.teamprj.weatherprj.entity.Member;
import com.teamprj.weatherprj.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class WeatherController {

    private final MemberService memberService;

    @GetMapping("/weather")
    public String getMethodName() {
        return "index";
    }
    
    @GetMapping("/map")
    public String map(Principal principal) {
        return "map";
    }
    
        // 2024-07-16 박창현 추가
    @GetMapping("/openWeather")
    public String openWeather(Principal principal, Model model,@RequestParam(name = "lat") String lat,
                                @RequestParam(name = "lng")String lng, @RequestParam(name = "location") String location) {
        String loginedMember = principal.getName();
        Member member = memberService.findbyUserId(loginedMember);
        model.addAttribute("lat",lat);
        model.addAttribute("lng", lng);
        model.addAttribute("loginedMember", member);
        model.addAttribute("locationName",location);
        System.out.println(lat);
        System.out.println(lng);
        System.out.println(location);
        return "openWeather";
    }
}
