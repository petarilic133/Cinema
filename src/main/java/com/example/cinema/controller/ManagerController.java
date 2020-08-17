package com.example.cinema.controller;

import com.example.cinema.service.IManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/managers")
public class ManagerController {

    private final IManagerService _managerService;

    public ManagerController(IManagerService managerService) {
        _managerService = managerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getManager(@PathVariable UUID id) throws Exception{
        try {
            return new ResponseEntity<>(_managerService.getManager(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllManagers() throws Exception{
        try {
            return new ResponseEntity<>(_managerService.getAllManagers(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteManager(@PathVariable UUID id) throws Exception{
        try {
            return new ResponseEntity<>(_managerService.deleteManager(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
