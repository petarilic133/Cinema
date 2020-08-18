package com.example.cinema.service;

import com.example.cinema.dto.request.CreateHallRequest;
import com.example.cinema.dto.request.UpdateHallRequest;
import com.example.cinema.dto.response.HallResponse;

import java.util.Set;
import java.util.UUID;

public interface IHallService {

    HallResponse createHall(CreateHallRequest request) throws Exception;

    HallResponse updateHall(UpdateHallRequest request) throws Exception;

    HallResponse getHall(UUID id) throws Exception;

    Set<HallResponse> getAllHallsByCinema(UUID id) throws Exception;

    HallResponse deleteHall(UUID id) throws Exception;
}
