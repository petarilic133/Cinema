package com.example.cinema.service;

import com.example.cinema.dto.request.CreateUserRequest;
import com.example.cinema.dto.response.UserResponse;

import java.util.Set;
import java.util.UUID;

public interface IAdminService {

    UserResponse getAdmin(UUID id) throws Exception;

    Set<UserResponse> getAllAdmins() throws Exception;

    UserResponse deleteAdmin(UUID id) throws Exception;
}
