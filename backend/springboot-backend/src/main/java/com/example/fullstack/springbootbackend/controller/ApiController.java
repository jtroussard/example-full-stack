package com.example.fullstack.springbootbackend.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {
    
    @GetMapping("/hello")
    public ResponseEntity<Object> sayHello() {
        log.info("[API] /hello endpoint hit.");
        try {
            // Create a JSON object with the desired response
            // Use a Map or a custom DTO class
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("message", "Howdy Partner!");
            // Return the JSON object along with a success status code
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            // If an error occurs, return an error response
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }
}
