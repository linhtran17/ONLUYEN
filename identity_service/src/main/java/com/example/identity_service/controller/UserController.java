package com.example.identity_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.identity_service.dto.response.UserResponse;
import com.example.identity_service.dto.resquest.ApiResponse;
import com.example.identity_service.dto.resquest.UserCreationRequest;
import com.example.identity_service.dto.resquest.UserUpdateRequest;
import com.example.identity_service.entity.User;
import com.example.identity_service.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/users")
public class UserController {
@Autowired
private UserService userService;

  @PostMapping
    public ResponseEntity<ApiResponse<User>> createUser(@Valid @RequestBody UserCreationRequest request) {
        User created = userService.createUser(request);
        return ResponseEntity.ok(ApiResponse.ok(created)); // status=200, code=1000
    }
  @GetMapping
    public ResponseEntity<ApiResponse<List<User>>> getUsers() {
        return ResponseEntity.ok(ApiResponse.ok(userService.getUsers()));
    }

@GetMapping("/{userId}")
UserResponse getUser(@PathVariable("userId") String userId){
    return userService.getUser(userId);
}


 @PutMapping("/{userId}")

 UserResponse updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request){
    return userService.updateUser(userId, request);
}

@DeleteMapping("/{userId}")

public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return ResponseEntity.ok(ApiResponse.ok("User has been deleted"));

}


}
