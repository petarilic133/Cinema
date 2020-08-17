package com.example.cinema.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CinemaResponse {

    private UUID id;

    private String name;

    private String email;

    private String address;

    private String phone;
}
