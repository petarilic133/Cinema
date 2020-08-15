package com.example.cinema.controller;

import com.example.cinema.dto.request.CreateUserRequest;
import com.example.cinema.dto.response.UserResponse;
import com.example.cinema.service.IUserService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("users")
public class UserController {

    private final IUserService _userService;

    public UserController(IUserService userService) {
        _userService = userService;
    }

    @PutMapping
    public UserResponse updateUser(@RequestBody CreateUserRequest request) throws Exception{
        return _userService.updateUser(request);
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable UUID id) throws Exception{
        return _userService.getUser(id);
    }

    @GetMapping
    public Set<UserResponse> getAllUsers() throws Exception{
        return _userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public UserResponse deleteUser(@PathVariable UUID id) throws Exception{
        return _userService.deleteUser(id);
    }
}
