package com.teamprj.weatherprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class OpenWeather {
    @GetMapping("/openweather")
    public String getMethodName() {
        return "openWeather";
    }
    
}