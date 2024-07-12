package com.teamprj.weatherprj.service;

import java.util.Optional;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.teamprj.weatherprj.OAuth2.CustomOauth2UserDetails;
import com.teamprj.weatherprj.OAuth2.KakaoUserDetails;
import com.teamprj.weatherprj.OAuth2.NaverUserDetails;
import com.teamprj.weatherprj.OAuth2.OAuth2UserInfo;
import com.teamprj.weatherprj.entity.Member;
import com.teamprj.weatherprj.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomOauth2UserService extends DefaultOAuth2UserService{
    
    private final MemberRepository memberRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException{
        OAuth2User oAuth2User = super.loadUser(userRequest);
        
        String provider = userRequest.getClientRegistration().getRegistrationId();

        OAuth2UserInfo oAuth2UserInfo = null;

        if(provider.equals("naver")){
            log.info("네이버 로그인");
            oAuth2UserInfo = new NaverUserDetails(oAuth2User.getAttributes());
            log.info("뭐가 나올까={}",oAuth2UserInfo);
        }
        if(provider.equals("kakao")){
            log.info("카카오 로그인");
            oAuth2UserInfo = new KakaoUserDetails(oAuth2User.getAttributes());
            log.info("~~~~={},",oAuth2UserInfo);
        }

        String providerId = oAuth2UserInfo.getProviderId();

        Optional<Member> findMember = memberRepository.findByUserId(providerId);
        Member member;
        if(findMember.isPresent()){
            member = findMember.get();
        }else{
            member = Member.builder()
                    .userId(providerId)
                    .provider(provider)
                    .build();
            memberRepository.save(member);
            }
        
        return new CustomOauth2UserDetails(member, oAuth2User.getAttributes());
    }
}
