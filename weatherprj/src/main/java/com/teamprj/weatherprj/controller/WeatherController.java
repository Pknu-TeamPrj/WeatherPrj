package com.teamprj.weatherprj.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.teamprj.weatherprj.entity.Comment;
import com.teamprj.weatherprj.entity.Member;
import com.teamprj.weatherprj.service.CommentService;
import com.teamprj.weatherprj.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class WeatherController {

    private final MemberService memberService;
    private final CommentService commentService;

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
        //멤버 찾기
        Member member = memberService.findbyUserId(loginedMember);

        // 코멘트 리스트 찾아오기
        List<Comment> commentList = commentService.findByArea3(location);

        // 각각에 맞는 모델명이 추가해 주기
        model.addAttribute("lat",lat);
        model.addAttribute("lng", lng);
        model.addAttribute("loginedMember", member);
        model.addAttribute("locationName",location);
        model.addAttribute("commentList", commentList);
        return "openWeather";
    }
}
