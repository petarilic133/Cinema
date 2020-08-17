package com.example.cinema.dto.request;

import com.example.cinema.util.emums.GenreType;
import lombok.Data;

@Data
public class CreateMovieRequest {

    private String name;

    private String duration;

    private GenreType genreType;

    private String description;
}
