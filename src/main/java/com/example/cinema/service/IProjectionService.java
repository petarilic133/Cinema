package com.example.cinema.service;

import com.example.cinema.dto.request.CreateProjectionRequest;
import com.example.cinema.dto.request.GetProjectionsInCinemaForMovieRequest;
import com.example.cinema.dto.request.ReserveRequest;
import com.example.cinema.dto.response.ProjectionResponse;

import java.util.Set;
import java.util.UUID;

public interface IProjectionService {

    ProjectionResponse createProjection(CreateProjectionRequest request) throws Exception;

    ProjectionResponse getProjection(UUID id) throws Exception;

    ProjectionResponse deleteProjection(UUID id) throws Exception;

    Set<ProjectionResponse> getAllProjectionsByCinema(UUID id) throws Exception;

    Set<ProjectionResponse> getAllProjectionsByMovie(UUID id) throws Exception;

    Set<ProjectionResponse> getAllProjectionsByMovieAndCinema(GetProjectionsInCinemaForMovieRequest request) throws Exception;

    Set<ProjectionResponse> getAllProjectionsByHall(UUID id) throws Exception;

    ProjectionResponse reserve(ReserveRequest request) throws Exception;

    ProjectionResponse cancelReservation(ReserveRequest request) throws Exception;

    Set<ProjectionResponse> getAllProjectionsByCustomer(UUID id) throws Exception;
}
