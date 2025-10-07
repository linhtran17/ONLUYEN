package com.example.identity_service.mapper;

import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.control.MappingControl.Use;

import com.example.identity_service.dto.response.UserResponse;
import com.example.identity_service.dto.resquest.UserCreationRequest;
import com.example.identity_service.dto.resquest.UserUpdateRequest;
import com.example.identity_service.entity.User;

@Mapper(componentModel="spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse  toUserResponse(User user);

    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}