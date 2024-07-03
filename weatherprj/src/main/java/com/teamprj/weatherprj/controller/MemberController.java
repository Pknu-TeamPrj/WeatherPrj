package com.teamprj.weatherprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.teamprj.weatherprj.dto.UserDto;
import com.teamprj.weatherprj.entity.Member;
import com.teamprj.weatherprj.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor    // 생성자 방식으로 의존성 주입
@Controller
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/login")
    public String login() {
        return "member/login";
    }

    @GetMapping("/join")
    public String join() {
        return "member/join";
    }

    @PostMapping("/join")
    public String join(UserDto userDto) {
        Member member = Member.builder()
                            .userId(userDto.getUserId())
                            .userPassword(userDto.getUserPassword())
                            .userName(userDto.getUserName())
                            .userBirth(userDto.getUserBirth())
                            .userEmail(userDto.getUserEmail()).build();
        memberRepository.save(member);
                            
        return "member/login";
    }
    


}
