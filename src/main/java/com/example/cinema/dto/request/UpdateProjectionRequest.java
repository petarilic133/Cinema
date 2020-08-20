package com.example.cinema.dto.request;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
public class UpdateProjectionRequest {

    private UUID projectionId;

    private double price;

    private LocalDate date;

    private LocalTime time;

    private UUID movieId;

    private UUID hallId;
}
