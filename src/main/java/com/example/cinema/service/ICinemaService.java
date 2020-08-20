package com.example.cinema.service;

import com.example.cinema.dto.request.CreateCinemaRequest;
import com.example.cinema.dto.request.SetNewManagerRequest;
import com.example.cinema.dto.response.CinemaResponse;

import java.util.Set;
import java.util.UUID;

public interface ICinemaService {

    CinemaResponse createCinema(CreateCinemaRequest request) throws Exception;

    CinemaResponse getCinema(UUID id) throws Exception;

    CinemaResponse updateCinema(CreateCinemaRequest request) throws Exception;

    Set<CinemaResponse> getAllCinemas() throws Exception;

    Set<CinemaResponse> getAllCinemasByManager(UUID id) throws Exception;

    CinemaResponse deleteCinema(UUID id) throws Exception;

    CinemaResponse setNewManager(SetNewManagerRequest request) throws Exception;
}
