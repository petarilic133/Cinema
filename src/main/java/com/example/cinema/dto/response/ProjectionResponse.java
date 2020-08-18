package com.example.cinema.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectionResponse {

    private UUID id;

    private LocalDate date;

    private LocalTime time;

    private String hallMark;

    private String cinemaName;

    private String movieName;

    private int duration;

    private double price;
}
