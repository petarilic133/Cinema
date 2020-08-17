package com.example.cinema.repository;

import com.example.cinema.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface ICinemaRepository extends JpaRepository<Cinema, UUID> {

    Cinema findOneById(UUID id);

    Set<Cinema> findAllByDeleted(boolean deleted);

    Cinema findOneByNameAndDeleted(String name, boolean deleted);

    Cinema findOneByAddressAndDeleted(String address, boolean deleted);

    Cinema findOneByEmailAndDeleted(String email, boolean deleted);
}
