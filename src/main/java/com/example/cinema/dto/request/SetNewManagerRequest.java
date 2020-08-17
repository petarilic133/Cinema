package com.example.cinema.dto.request;

import lombok.Data;

import java.util.UUID;

@Data
public class SetNewManagerRequest {

    private UUID managerId;

    private UUID cinemaId;
}
