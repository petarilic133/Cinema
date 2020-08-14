package com.example.cinema.repository;

import com.example.cinema.entity.Admin;
import com.example.cinema.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, UUID> {

    Admin findOneById(UUID id);

    Admin findOneByUser(User user);

    Admin findOneByIdAndUser_Deleted(UUID id, boolean deleted);

    Admin findOneByUser_UsernameAndUser_Deleted(String username, boolean deleted);

    Admin findOneByUser_EmailAndUser_Deleted(String email, boolean deleted);

    Set<Admin> findAllByUser_Deleted(boolean deleted);
}
