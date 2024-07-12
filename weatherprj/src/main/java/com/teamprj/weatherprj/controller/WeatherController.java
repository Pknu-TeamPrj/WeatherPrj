package com.teamprj.weatherprj.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class WeatherController {
    @GetMapping("/weather")
    public String getMethodName() {
        return "weather";
    }
    
    @GetMapping("/map")
    public String map(Principal principal) {
        log.info("유저의 이름 : {}", principal.getName());
        return "map";
    }
    
}
