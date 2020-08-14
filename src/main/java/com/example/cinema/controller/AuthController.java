package com.example.cinema.controller;

import com.example.cinema.dto.request.CreateUserRequest;
import com.example.cinema.dto.request.LoginRequest;
import com.example.cinema.service.IAuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final IAuthService _authService;

    public AuthController(IAuthService authService) {
        _authService = authService;
    }

    @PostMapping("/customer-registration")
    public ResponseEntity<?> registerCustomer(@RequestBody CreateUserRequest request) throws Exception{
        try {
            return new ResponseEntity<>(_authService.registerCustomer(request), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("User with the same username/email already exists.", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/manager-registration")
    public ResponseEntity<?> registerManager(@RequestBody CreateUserRequest request) throws Exception{
        try {
            return new ResponseEntity<>(_authService.registerManager(request), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("User with the same username/email already exists.", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) throws Exception{
        try {
            return new ResponseEntity<>(_authService.login(request), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Bad credentials.", HttpStatus.BAD_REQUEST);
        }
    }
}
