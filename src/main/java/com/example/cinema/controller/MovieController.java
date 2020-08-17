package com.example.cinema.controller;

import com.example.cinema.dto.request.CreateMovieRequest;
import com.example.cinema.dto.request.GetAllMoviesByGenreTypeRequest;
import com.example.cinema.service.IMovieService;
import com.example.cinema.util.emums.GenreType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final IMovieService _movieService;

    public MovieController(IMovieService movieService) {
        _movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<?> createMovie(@RequestBody CreateMovieRequest request) throws Exception{
        try {
            return new ResponseEntity<>(_movieService.createMovie(request), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Movie with the same name already exists.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateMovie(@RequestBody CreateMovieRequest request) throws Exception{
        try {
            return new ResponseEntity<>(_movieService.updateMovie(request), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMovie(@PathVariable UUID id) throws Exception{
        try {
            return new ResponseEntity<>(_movieService.getMovie(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable UUID id) throws Exception{
        try {
            return new ResponseEntity<>(_movieService.deleteMovie(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllMovies() throws Exception{
        try {
            return new ResponseEntity<>(_movieService.getAllMovies(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/genre-type")
    public ResponseEntity<?> getAllMoviesByGenreType(GetAllMoviesByGenreTypeRequest request) throws Exception{
        try {
            return new ResponseEntity<>(_movieService.getAllMoviesByGenreType(request), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
