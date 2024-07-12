package com.teamprj.weatherprj.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer uno;    // PK값

    @Column (unique = true)
    private String userId;

    private String userPassword;

    private String userName;

    private String userBirth;

    @Column (unique = true)
    private String userEmail;

    private String provider;
}
