package com.example.cinema.controller;

import com.example.cinema.dto.request.CreateProjectionRequest;
import com.example.cinema.service.IProjectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/projections")
public class ProjectionController {

    private final IProjectionService _projectionService;

    public ProjectionController(IProjectionService projectionService) {
        _projectionService = projectionService;
    }

    @PostMapping
    public ResponseEntity<?> createProjection(@RequestBody CreateProjectionRequest request) throws Exception{
        try{
            return new ResponseEntity<>(_projectionService.createProjection(request), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProjection(@PathVariable UUID id) throws Exception{
        try{
            return new ResponseEntity<>(_projectionService.getProjection(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProjection(@PathVariable UUID id) throws Exception{
        try{
            return new ResponseEntity<>(_projectionService.deleteProjection(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}/cinema")
    public ResponseEntity<?> getAllProjectionsByCinema(@PathVariable UUID id) throws Exception{
        try{
            return new ResponseEntity<>(_projectionService.getAllProjectionsByCinema(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}/movie")
    public ResponseEntity<?> getAllProjectionsByMovie(@PathVariable UUID id) throws Exception{
        try{
            return new ResponseEntity<>(_projectionService.getAllProjectionsByMovie(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
