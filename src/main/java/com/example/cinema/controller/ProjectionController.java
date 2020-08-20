package com.example.cinema.controller;

import com.example.cinema.dto.request.CreateProjectionRequest;
import com.example.cinema.dto.request.GetProjectionsInCinemaForMovieRequest;
import com.example.cinema.dto.request.ReserveRequest;
import com.example.cinema.dto.request.UpdateProjectionRequest;
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
            return new ResponseEntity<>("Change date or time", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateProjection(@RequestBody UpdateProjectionRequest request) throws Exception{
        try{
            return new ResponseEntity<>(_projectionService.updateProjection(request), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Change date or time", HttpStatus.BAD_REQUEST);
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

    @GetMapping("/{id}/hall")
    public ResponseEntity<?> getAllProjectionsByHall(@PathVariable UUID id) throws Exception{
        try{
            return new ResponseEntity<>(_projectionService.getAllProjectionsByHall(id), HttpStatus.OK);
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

    @GetMapping("/by-cinema-and-movie")
    public ResponseEntity<?> getAllProjectionsByCinemaAndMovie(@RequestBody GetProjectionsInCinemaForMovieRequest request) throws Exception{
        try{
            return new ResponseEntity<>(_projectionService.getAllProjectionsByMovieAndCinema(request), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/reserve")
    public ResponseEntity<?> reserve(@RequestBody ReserveRequest request) throws Exception{
        try{
            return new ResponseEntity<>(_projectionService.reserve(request), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("You have already reserved this projection.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/cancel-reservation")
    public ResponseEntity<?> cancelReservation(@RequestBody ReserveRequest request) throws Exception{
        try{
            return new ResponseEntity<>(_projectionService.cancelReservation(request), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("You can only cancel reservation day before projection.", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}/customer")
    public ResponseEntity<?> getAllProjectionsByCustomer(@PathVariable UUID id) throws Exception{
        try{
            return new ResponseEntity<>(_projectionService.getAllProjectionsByCustomer(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}/customers-past-projections")
    public ResponseEntity<?> getAllPastProjectionsByCustomer(@PathVariable UUID id) throws Exception{
        try{
            return new ResponseEntity<>(_projectionService.getAllPastProjectionsByCustomer(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
