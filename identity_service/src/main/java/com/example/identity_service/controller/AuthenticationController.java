package com.example.identity_service.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.identity_service.dto.response.AuthenticationResponse;
import com.example.identity_service.dto.resquest.ApiResponse;
import com.example.identity_service.dto.resquest.AuthenticationRequest;
import com.example.identity_service.service.AuthenticationService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController

@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class AuthenticationController {
    AuthenticationService authenticationService;

 
    @PostMapping("/login")
public ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
    boolean result = authenticationService.authenticated(request);
    return ApiResponse.ok(AuthenticationResponse.builder().authenticated(result).build());
}


}
