package com.example.cinema.dto.request;

import lombok.Data;

import java.util.UUID;

@Data
public class ReserveRequest {

    private UUID projectionId;

    private UUID customerId;
}
