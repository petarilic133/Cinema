package com.example.cinema.repository;

import com.example.cinema.entity.Movie;
import com.example.cinema.util.emums.GenreType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, UUID> {

    Movie findOneById(UUID id);

    Movie findOneByNameAndDeleted(String name, boolean deleted);

    Set<Movie> findAllByDeleted(boolean deleted);

    Set<Movie> findAllByGenreTypeAndDeleted(GenreType genreType, boolean deleted);
}
