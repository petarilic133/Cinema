package com.example.cinema.repository;

import com.example.cinema.entity.Customer;
import com.example.cinema.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, UUID> {

    Customer findOneById(UUID id);

    Customer findOneByUser(User user);

    Customer findOneByIdAndUser_Deleted(UUID id, boolean deleted);

    Customer findOneByUser_UsernameAndUser_Deleted(String username, boolean deleted);

    Customer findOneByUser_EmailAndUser_Deleted(String email, boolean deleted);

    Set<Customer> findAllByUser_Deleted(boolean deleted);
}
