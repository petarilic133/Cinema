package com.example.cinema.repository;

import com.example.cinema.entity.Admin;
import com.example.cinema.entity.Customer;
import com.example.cinema.entity.Manager;
import com.example.cinema.entity.User;
import com.example.cinema.util.emums.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface IUserRepository extends JpaRepository<User, UUID> {

    User findOneById(UUID id);

    User findOneByIdAndDeleted(UUID id, boolean deleted);

    User findOneByUsernameAndDeleted(String username, boolean deleted);

    User findOneByEmailAndDeleted(String email, boolean deleted);

    Set<User> findAllByDeleted(boolean deleted);

    Set<User> findAllByUserTypeAndDeleted(UserType userType, boolean deleted);

    User findOneByAdmin(Admin admin);

    User findOneByCustomer(Customer customer);

    User findOneByManager(Manager manager);
}
