package com.teamprj.weatherprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BoardController {

    @GetMapping("/board")
    public String board() {
        return "board/board";
    }

    @GetMapping("/write")
    public String write() {
        return "board/write";
    }

}
