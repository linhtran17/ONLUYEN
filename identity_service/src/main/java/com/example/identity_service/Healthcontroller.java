package com.example.identity_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Healthcontroller {
@GetMapping("/api/health")
public String hello(){
    return "OK";
}

}
