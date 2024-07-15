package com.teamprj.weatherprj.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamprj.weatherprj.entity.Member;
import com.teamprj.weatherprj.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
    
    @Autowired
    private final MemberRepository memberRepository;



    // 2024-07-15 강정택 / ID로 멤버 찾기
    public Member findbyUserId(String userId){
        Optional<Member> member = memberRepository.findByUserId(userId);
        if(member.isPresent()){
            return member.get();
        }else{
            return null;
        }
    }

}
