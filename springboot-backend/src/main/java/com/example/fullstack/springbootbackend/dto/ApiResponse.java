package com.example.fullstack.springbootbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@lombok.Generated
public class ApiResponse {
    private String message;
    private boolean success;
}