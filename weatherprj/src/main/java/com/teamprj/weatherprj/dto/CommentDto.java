package com.teamprj.weatherprj.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private Long rno;
    private String content;     // 글내용
    private LocalDateTime createDate;   // 글 생성일
    private LocalDateTime modifyDate;   // 글 수정일
    private String writer;  // 작성자
}