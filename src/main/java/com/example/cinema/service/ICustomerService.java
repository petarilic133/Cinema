package com.example.cinema.service;

import com.example.cinema.dto.response.UserResponse;

import java.util.Set;
import java.util.UUID;

public interface ICustomerService {

    UserResponse getCustomer(UUID id) throws Exception;

    Set<UserResponse> getAllCustomers() throws Exception;

    UserResponse deleteCustomer(UUID id) throws Exception;
}
