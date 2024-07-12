package com.teamprj.weatherprj.OAuth2;

import lombok.AllArgsConstructor;
import java.util.Map;

@AllArgsConstructor
public class KakaoUserDetails implements OAuth2UserInfo{
    
    private Map<String,Object> attributes;

    @Override
    public String getProvider(){
        return "kakao";
    }

    @Override
    public String getProviderId() {        
        return attributes.get("id").toString();
    }
}
