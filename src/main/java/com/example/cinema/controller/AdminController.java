package com.example.cinema.controller;

import com.example.cinema.dto.response.UserResponse;
import com.example.cinema.service.IAdminService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/admins")
public class AdminController {

    private final IAdminService _adminService;

    public AdminController(IAdminService adminService) {
        _adminService = adminService;
    }

    @GetMapping("/{id}")
    public UserResponse getAdmin(@PathVariable UUID id) throws Exception{
        return _adminService.getAdmin(id);
    }

    @GetMapping
    public Set<UserResponse> getAllAdmins() throws Exception{
        return _adminService.getAllAdmins();
    }

    @DeleteMapping("/{id}")
    public UserResponse deleteAdmin(@PathVariable UUID id) throws Exception{
        return _adminService.deleteAdmin(id);
    }
}
