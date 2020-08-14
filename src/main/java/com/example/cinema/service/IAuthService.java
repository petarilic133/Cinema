package com.example.cinema.service;

import com.example.cinema.dto.request.CreateUserRequest;
import com.example.cinema.dto.request.LoginRequest;
import com.example.cinema.dto.response.UserResponse;
import com.example.cinema.entity.User;

public interface IAuthService{

    User createUser(CreateUserRequest request) throws Exception;

    UserResponse registerCustomer(CreateUserRequest request) throws Exception;

    UserResponse registerManager(CreateUserRequest request) throws Exception;

    UserResponse login(LoginRequest request) throws Exception;
}
