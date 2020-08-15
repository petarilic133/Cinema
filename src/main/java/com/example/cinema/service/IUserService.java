package com.example.cinema.service;

import com.example.cinema.dto.request.CreateUserRequest;
import com.example.cinema.dto.response.UserResponse;

import java.util.Set;
import java.util.UUID;

public interface IUserService {

    UserResponse getUser(UUID id) throws Exception;

    Set<UserResponse> getAllUsers() throws Exception;

    UserResponse updateUser(CreateUserRequest request) throws Exception;

    UserResponse deleteUser(UUID id) throws Exception;
}
