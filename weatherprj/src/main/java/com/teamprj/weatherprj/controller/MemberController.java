package com.teamprj.weatherprj.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.teamprj.weatherprj.entity.Member;
import com.teamprj.weatherprj.repository.MemberRepository;
// import com.teamprj.weatherprj.entity.Member;
// import com.teamprj.weatherprj.repository.MemberRepository;
import com.teamprj.weatherprj.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;




@RequiredArgsConstructor    // 생성자 방식으로 의존성 주입
@Controller
public class MemberController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;

    @GetMapping("/login")
    public String login() {
        return "member/login";
    }

    @GetMapping("/join")
    public String join() {
        return "member/join";
    }

    // 2024-07-14 강정택 수정
    @GetMapping("/memberReg")
    public String memberReg(Principal principal,Model model) {

        // principal에 저장된 값으로 member의 아이디를 찾습니다.
        String loginedMember = principal.getName();
        //찾아온 member ID로 데이터베이스에 접근 후 그 값이 존재한다면 member 객체를 반환합니다.
        Member member = memberService.findbyUserId(loginedMember);

        // 찾아온 member의 필드 중 age, nickname, sex 하나라도 null이라면 memberReg.html로 이동합니다.
        if(member.getUserAge() == null || member.getUserNickname() == null || member.getUserSex() == null){
            return "member/memberReg";
        }

        // 이미 있다면 model에 회원 객체 담아 map.html로 이동합니다.
        model.addAttribute("loginedMember", member);
        return "map";
    }

    @PostMapping("/memberReg")
    public String memberReg(@ModelAttribute Member member,Model model,Principal principal) {
        String memberId = principal.getName();
        Member member_ = memberService.findbyUserId(memberId);
        member_.setUserAge(member.getUserAge());
        member_.setUserNickname(member.getUserNickname());
        member_.setUserSex(member.getUserSex());
        
        Member member1 = memberRepository.save(member_);
        //회원 저장에 성공한다면 model에 회원 객체 담아 map.html로 이동합니다.
        model.addAttribute("loginedMember", member1);
        return "map";
    }

    // 2024-07-16 박창현 추가
    @GetMapping("/openWeather")
    public String openWeather(Principal principal, Model model) {
        String loginedMember = principal.getName();
        Member member = memberService.findbyUserId(loginedMember);

        model.addAttribute("loginedMember", member);
        return "openWeather";
    }
    
    
}
