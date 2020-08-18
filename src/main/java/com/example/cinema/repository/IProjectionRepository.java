package com.example.cinema.repository;

import com.example.cinema.entity.Cinema;
import com.example.cinema.entity.Movie;
import com.example.cinema.entity.Projection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface IProjectionRepository extends JpaRepository<Projection, UUID> {

    Projection findOneById(UUID id);

    Set<Projection> findAllByHall_CinemaAndDeleted(Cinema cinema, boolean deleted);

    Set<Projection> findAllByMovieAndDeleted(Movie movie, boolean deleted);

    Set<Projection> findAllByHall_CinemaAndMovieAndDeleted(Cinema cinema, Movie movie, boolean deleted);
}
