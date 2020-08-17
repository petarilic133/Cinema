package com.example.cinema.controller;

import com.example.cinema.dto.request.CreateCinemaRequest;
import com.example.cinema.dto.request.SetNewManagerRequest;
import com.example.cinema.service.ICinemaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cinemas")
public class CinemaController {

    private final ICinemaService _cinemaService;

    public CinemaController(ICinemaService cinemaService) {
        _cinemaService = cinemaService;
    }

    @PostMapping
    public ResponseEntity<?> createCinema(@RequestBody CreateCinemaRequest request) throws Exception{
        try {
            return new ResponseEntity<>(_cinemaService.createCinema(request), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Cinema with the same name/address/email already exists.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateCinema(@RequestBody CreateCinemaRequest request) throws Exception{
        try {
            return new ResponseEntity<>(_cinemaService.updateCinema(request), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Cinema with the same address/email already exists.", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCinema(@PathVariable UUID id) throws Exception{
        try {
            return new ResponseEntity<>(_cinemaService.getCinema(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity<?> getAllCinemas() throws Exception{
        try {
            return new ResponseEntity<>(_cinemaService.getAllCinemas(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCinema(@PathVariable UUID id) throws Exception{
        try {
            return new ResponseEntity<>(_cinemaService.deleteCinema(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("set-new-manager")
    public ResponseEntity<?> setNewManager(@RequestBody SetNewManagerRequest request) throws Exception{
        try {
            return new ResponseEntity<>(_cinemaService.setNewManager(request), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("This cinema already has that manager.", HttpStatus.BAD_REQUEST);
        }
    }
}
