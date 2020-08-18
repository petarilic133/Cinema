package com.example.cinema.dto.request;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateHallRequest {

    private String mark;

    private int capacity;

    private UUID cinemaId;
}
