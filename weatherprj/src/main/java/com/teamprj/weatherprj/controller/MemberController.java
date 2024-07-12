package com.teamprj.weatherprj.controller;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.teamprj.weatherprj.dto.UserDto;
// import com.teamprj.weatherprj.entity.Member;
// import com.teamprj.weatherprj.repository.MemberRepository;
import com.teamprj.weatherprj.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor    // 생성자 방식으로 의존성 주입
@Controller
public class MemberController {

    // private final MemberRepository memberRepository;
    private final MemberService memberService;

    @GetMapping("/login")
    public String login() {
        return "member/login";
    }

    @GetMapping("/join")
    public String join() {
        return "member/join";
    }

    @PostMapping("/join")
    public String join(UserDto userDto, BindingResult bindingResult) {
        // Member member = Member.builder()
        //                     .userId(userDto.getUserId())
        //                     .userPassword(userDto.getUserPassword())
        //                     .userName(userDto.getUserName())
        //                     .userBirth(userDto.getUserBirth())
        //                     .userEmail(userDto.getUserEmail()).build();
        // memberRepository.save(member);

        if (bindingResult.hasErrors()) {
            return "member/join";
        }
        
        try {
            this.memberService.setMember(userDto.getUserId(),userDto.getUserPassword(),userDto.getUserName(),userDto.getUserBirth(),userDto.getUserEmail());
        }catch (ConstraintViolationException e){
            e.printStackTrace();
            bindingResult.reject("registerFailde","이미 등록된 사용자입니다.");
            return "member/login";
        }
         catch (Exception e) {
            e.printStackTrace();
            return "member/login";
        }
                            
        return "member/login";
        
    }
    
}
