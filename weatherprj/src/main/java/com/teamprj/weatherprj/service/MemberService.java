package com.teamprj.weatherprj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.teamprj.weatherprj.repository.MemberRepository;
import com.teamprj.weatherprj.entity.Member;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
    
    @Autowired
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member setMember(String userId, String userPassword, String userName, String userBirth, String userEmail) {
        Member member = Member.builder().userId(userId).userName(userName).userBirth(userBirth).userEmail(userEmail).build();

        member.setUserPassword(passwordEncoder.encode(userPassword));   // 암호화된 값을 DB에 저장
        this.memberRepository.save(member);

        return member;
    }
}
