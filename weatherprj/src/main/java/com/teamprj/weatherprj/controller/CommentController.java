package com.teamprj.weatherprj.controller;

import java.security.Principal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teamprj.weatherprj.dto.CommentDto;
import com.teamprj.weatherprj.entity.Member;
import com.teamprj.weatherprj.service.CommentService;
import com.teamprj.weatherprj.service.MemberService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class CommentController {
    
    private final CommentService commentService;

    private final MemberService memberService;
    

    @PostMapping("/comment")
    @ResponseBody
    public ResponseEntity<String> postMethodName(@RequestBody CommentDto commentDto,
                                                    Principal principal) {
        String principalName = principal.getName();
        System.out.println(commentDto.getArea3());
        Member member = memberService.findbyUserId(principalName);

        System.out.println(commentDto.getContent());
        commentService.saveComment(commentDto.getContent(),commentDto.getArea3(),
                                    member);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
    
}
