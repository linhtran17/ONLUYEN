package com.example.springboot.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HelloSpringController {
    @GetMapping("/hello")
    String sayhello(){
        return "Helo springboot";
    }
    
}
