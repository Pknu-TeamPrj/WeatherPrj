package com.teamprj.weatherprj.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.teamprj.weatherprj.entity.Comment;
import com.teamprj.weatherprj.entity.Member;
import com.teamprj.weatherprj.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
    
    private final CommentRepository commentRepository;

    public Comment saveComment(String content, String area3, Member member){
        Comment comment = Comment.builder().content(content).area3(area3).createDate(LocalDate.now()).member(member).build();
        return commentRepository.save(comment);
    }

    public List<Comment> findByArea3(String area3){
        return commentRepository.findByArea3(area3);
    }
}
