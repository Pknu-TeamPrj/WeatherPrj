package com.teamprj.weatherprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.teamprj.weatherprj.dto.CommentDto;
import com.teamprj.weatherprj.service.CommentService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class CommentController {
    
    private final CommentService commentService;

    

    @PostMapping("/comment")
    public String postMethodName(@ModelAttribute CommentDto commentDto) {

        return entity;
    }
    
}
