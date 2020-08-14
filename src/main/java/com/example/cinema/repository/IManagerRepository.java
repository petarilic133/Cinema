package com.example.cinema.repository;

import com.example.cinema.entity.Manager;
import com.example.cinema.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface IManagerRepository extends JpaRepository<Manager, UUID> {

    Manager findOneById(UUID id);

    Manager findOneByUser(User user);

    Manager findOneByIdAndUser_Deleted(UUID id, boolean deleted);

    Manager findOneByUser_UsernameAndUser_Deleted(String username, boolean deleted);

    Manager findOneByUser_EmailAndUser_Deleted(String email, boolean deleted);

    Set<Manager> findAllByUser_Deleted(boolean deleted);
}
