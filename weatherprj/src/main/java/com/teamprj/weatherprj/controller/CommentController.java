package com.teamprj.weatherprj.controller;

import java.security.Principal;
import java.time.LocalDate;

import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teamprj.weatherprj.dto.CommentDto;
import com.teamprj.weatherprj.entity.Comment;
import com.teamprj.weatherprj.entity.Member;
import com.teamprj.weatherprj.repository.CommentRepository;
import com.teamprj.weatherprj.service.CommentService;
import com.teamprj.weatherprj.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RequiredArgsConstructor
@Slf4j
public class CommentController {
    
    private final CommentService commentService;
    private final MemberService memberService;

    private final CommentRepository commentRepository;
    

    @PostMapping("/comment")
    @ResponseBody
    public ResponseEntity<String> postMethodName(@RequestBody CommentDto commentDto,
                                                    Principal principal) {
        String principalName = principal.getName();
        System.out.println(commentDto.getArea3());
        Member member = memberService.findbyUserId(principalName);

        System.out.println(commentDto.getContent());
        commentService.saveComment(commentDto.getContent(),commentDto.getArea3(),member,commentDto.getCno());
    
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @DeleteMapping("/comment/{cno}")
    public ResponseEntity<String> delete(@PathVariable("cno") Long cno) {
        Comment comment = this.commentRepository.findById(cno).get();
        
        this.commentService.deleteComment(comment);
        return new ResponseEntity<>(HttpStatus.OK);

    }
    
    @PutMapping("comment/{cno}")
    @ResponseBody
    public ResponseEntity<String> commentModify(@PathVariable(name = "cno") Long cno, @RequestBody String modifyText) {
        Comment comment = commentRepository.findById(cno).get();
        comment.setContent(modifyText);
        comment.setModifyDate(LocalDate.now());
        commentRepository.save(comment);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
