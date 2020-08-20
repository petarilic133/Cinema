package com.example.cinema.dto.response;

import com.example.cinema.util.emums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private UUID id;

    private String username;

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    private String dateOfBirth;

    private UserType userType;
}
