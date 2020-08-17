package com.example.cinema.service;

import com.example.cinema.dto.request.CreateMovieRequest;
import com.example.cinema.dto.request.GetAllMoviesByGenreTypeRequest;
import com.example.cinema.dto.response.MovieResponse;
import com.example.cinema.util.emums.GenreType;

import java.util.Set;
import java.util.UUID;

public interface IMovieService {

    MovieResponse createMovie(CreateMovieRequest request) throws Exception;

    MovieResponse updateMovie(CreateMovieRequest request) throws Exception;

    Set<MovieResponse> getAllMovies() throws Exception;

    MovieResponse getMovie(UUID id) throws Exception;

    Set<MovieResponse> getAllMoviesByGenreType(GetAllMoviesByGenreTypeRequest request) throws Exception;

    MovieResponse deleteMovie(UUID id) throws Exception;
}
