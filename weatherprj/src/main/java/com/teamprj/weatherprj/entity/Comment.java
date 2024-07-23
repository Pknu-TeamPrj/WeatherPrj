package com.teamprj.weatherprj.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {
    
    @Id
    private Long cno;

    @ManyToOne
    @JoinColumn(name = "uno")
    private Member member;

    @Column(nullable = false,length = 400)
    private String content;

    @Column(nullable = false,updatable = false)
    @CreatedDate
    private LocalDate createDate;

    @Column
    @CreatedDate
    private LocalDate modifyDate;

    @Column(nullable = false)
    private String area3;
}
