package com.example.cinema.repository;

import com.example.cinema.entity.Cinema;
import com.example.cinema.entity.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface IHallRepository extends JpaRepository<Hall, UUID> {

    Hall findOneById(UUID id);

    Hall findOneByCinemaAndMarkAndDeleted(Cinema cinema, String mark, boolean deleted);

    Set<Hall> findAllByCinemaAndDeleted(Cinema cinema, boolean deleted);

    Set<Hall> findAllByDeleted(boolean deleted);
}
