package com.example.cinema.dto.request;

import lombok.Data;

import java.util.UUID;

@Data
public class GetProjectionsInCinemaForMovieRequest {

    private UUID movieId;

    private UUID cinemaId;
}
