package com.example.cinema.dto.request;

import lombok.Data;

import java.util.Date;


@Data
public class CreateUserRequest {

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    private Date dateOfBirth;
}
