package com.example.cinema.controller;

import com.example.cinema.dto.response.UserResponse;
import com.example.cinema.service.IManagerService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/managers")
public class ManagerController {

    private final IManagerService _managerService;

    public ManagerController(IManagerService managerService) {
        _managerService = managerService;
    }

    @GetMapping("/{id}")
    public UserResponse getManager(@PathVariable UUID id) throws Exception{
        return _managerService.getManager(id);
    }

    @GetMapping
    public Set<UserResponse> getAllManagers() throws Exception{
        return _managerService.getAllManagers();
    }

    @DeleteMapping("/{id}")
    public UserResponse deleteManager(@PathVariable UUID id) throws Exception{
        return _managerService.deleteManager(id);
    }
}
