package com.teamprj.weatherprj.OAuth2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.teamprj.weatherprj.entity.Member;

public class CustomOauth2UserDetails implements UserDetails, OAuth2User{
    
    private final Member member;
    private Map<String,Object> attributes;

    public CustomOauth2UserDetails(Member member, Map<String,Object> attributes){
        this.member = member;
        this.attributes = attributes;
    }

    @Override
    public Map<String,Object> getAttributes(){
        return attributes;
    }

    @Override
    public String getName(){
        return null;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority(){
                return member.getUserId();
            }
        });
        return collection;
    }

    @Override
    public String getPassword(){
        return member.getUserPassword();
    }

    @Override
    public String getUsername(){
        return member.getUserId();
    }
}
