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

    @Column(nullable = false)
    private String userAge;

    @Column(nullable = false)
    private String userSex;

    @Column(nullable = false)
    private String userNickname;

    @Column(nullable = false)
    private String provider;
}
