package com.example.cinema.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponse {

    private UUID id;

    private String name;

    private int duration;

    private String genreType;

    private String description;
}
