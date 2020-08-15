package com.example.cinema.controller;

import com.example.cinema.dto.response.UserResponse;
import com.example.cinema.service.ICustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final ICustomerService _customerService;

    public CustomerController(ICustomerService customerService) {
        _customerService = customerService;
    }

    @GetMapping("/{id}")
    public UserResponse getCustomer(@PathVariable UUID id) throws Exception{
        return _customerService.getCustomer(id);
    }

    @GetMapping
    public Set<UserResponse> getAllCustomers() throws Exception{
        return _customerService.getAllCustomers();
    }

    @DeleteMapping("/{id}")
    public UserResponse deleteCustomer(@PathVariable UUID id) throws Exception{
        return _customerService.deleteCustomer(id);
    }
}
