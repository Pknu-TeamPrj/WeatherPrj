package com.teamprj.weatherprj.OAuth2;

import java.util.Map;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NaverUserDetails implements OAuth2UserInfo{
    
    private Map<String,Object> attributes;

    @Override
    public String getProvider(){
        return "naver";
    }
    
    @Override
    public String getProviderId(){
        return (String)((Map) attributes.get("response")).get("id");
    }
}
