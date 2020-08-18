package com.example.cinema.dto.request;

import lombok.Data;

import java.util.UUID;

@Data
public class UpdateHallRequest {

    private UUID hallId;

    private int capacity;

    private String mark;
}
