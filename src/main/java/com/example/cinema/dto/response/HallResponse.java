package com.example.cinema.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HallResponse {

    private UUID id;

    private String mark;

    private int capacity;

    private String cinemaName;
}
