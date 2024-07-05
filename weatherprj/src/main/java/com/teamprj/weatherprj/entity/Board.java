package com.teamprj.weatherprj.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long bno;   //PK값

    private String title;

    private String writer;

    private LocalDateTime createDate;
}
