package com.example.fullstack.springbootbackend.controller;

import com.example.fullstack.springbootbackend.dto.ApiResponse;
import com.example.fullstack.springbootbackend.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.MethodArgumentNotValidException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {

    private final ExampleService exampleService;

    @Autowired
    public ApiController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @GetMapping("/hello")
    public ResponseEntity<ApiResponse> sayHello() {
        log.info("[API] /hello endpoint hit.");
        ApiResponse response = new ApiResponse("Howdy Partner!", true);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/greeting")
    public ResponseEntity<ApiResponse> getGreeting(@RequestParam(name = "choice", required = false, defaultValue = "0") int choice) {
        log.info("[API] /greeting endpoint hit.");
        String greeting = exampleService.getStylizedGreeting(choice);
        ApiResponse response = new ApiResponse(greeting, true);
        return ResponseEntity.ok(response);
    }

    @lombok.Generated
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleException(Exception e) {
        log.error("[API] An error occurred: {}", e.getMessage());
        ApiResponse errorResponse = new ApiResponse(e.getMessage(), false);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @lombok.Generated
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleValidationExceptions(MethodArgumentNotValidException e) {
        log.error("[API] An error occurred: {}", e.getMessage());
        ApiResponse errorResponse = new ApiResponse(e.getBindingResult().toString(), false);
        return ResponseEntity.badRequest().body(errorResponse);
    }
}