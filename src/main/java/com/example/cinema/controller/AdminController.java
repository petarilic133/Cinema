package com.example.cinema.controller;

import com.example.cinema.service.IAdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/admins")
public class AdminController {

    private final IAdminService _adminService;

    public AdminController(IAdminService adminService) {
        _adminService = adminService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAdmin(@PathVariable UUID id) throws Exception{
        try {
            return new ResponseEntity<>(_adminService.getAdmin(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllAdmins() throws Exception{
        try {
            return new ResponseEntity<>(_adminService.getAllAdmins(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable UUID id) throws Exception{
        try {
            return new ResponseEntity<>(_adminService.deleteAdmin(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
