package com.example.cinema.dto.request;

import com.example.cinema.util.emums.GenreType;
import lombok.Data;

@Data
public class GetAllMoviesByGenreTypeRequest {

    private GenreType genreType;
}
