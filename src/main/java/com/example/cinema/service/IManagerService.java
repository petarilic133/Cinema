package com.example.cinema.service;

import com.example.cinema.dto.response.UserResponse;

import java.util.Set;
import java.util.UUID;

public interface IManagerService {

    UserResponse getManager(UUID id) throws Exception;

    Set<UserResponse> getAllManagers() throws Exception;

    UserResponse deleteManager(UUID id) throws Exception;
}
