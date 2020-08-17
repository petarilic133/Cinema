package com.example.cinema.dto.request;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateCinemaRequest {

    private String name;

    private String email;

    private String address;

    private String phone;

    private UUID managerId;
}
