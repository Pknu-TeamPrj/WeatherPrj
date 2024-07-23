package com.teamprj.weatherprj.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
    
    private String userId;

    private String userPassword;

    private String userName;

    private String userBirth;

    private String userEmail;
}
