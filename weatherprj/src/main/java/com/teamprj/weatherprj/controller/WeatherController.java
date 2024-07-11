package com.teamprj.weatherprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherController {
    @GetMapping("/weather")
    public String getMethodName() {
        return "weather";
    }
    
    @GetMapping("/map")
    public String map() {
        return "map";
    }
    
}
