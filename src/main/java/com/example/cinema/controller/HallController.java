package com.example.cinema.controller;

import com.example.cinema.dto.request.CreateHallRequest;
import com.example.cinema.dto.request.UpdateHallRequest;
import com.example.cinema.service.IHallService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/halls")
public class HallController {

    private final IHallService _hallService;

    public HallController(IHallService hallService) {
        _hallService = hallService;
    }

    @PostMapping
    public ResponseEntity<?> createHall(@RequestBody CreateHallRequest request) throws Exception{
        try {
            return new ResponseEntity<>(_hallService.createHall(request), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("In this cinema hall with the same name already exists.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateHall(@RequestBody UpdateHallRequest request) throws Exception{
        try {
            return new ResponseEntity<>(_hallService.updateHall(request), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("In this cinema hall with the same name already exists.", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getHall(@PathVariable UUID id) throws Exception{
        try {
            return new ResponseEntity<>(_hallService.getHall(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}/cinema")
    public ResponseEntity<?> getAllHallsByCinema(@PathVariable UUID id) throws Exception{
        try {
            return new ResponseEntity<>(_hallService.getAllHallsByCinema(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHall(@PathVariable UUID id) throws Exception{
        try {
            return new ResponseEntity<>(_hallService.deleteHall(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
