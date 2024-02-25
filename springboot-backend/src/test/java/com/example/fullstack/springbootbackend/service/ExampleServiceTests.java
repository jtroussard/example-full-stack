package com.example.fullstack.springbootbackend.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ExampleServiceTest {

    private ExampleService exampleService;

    @BeforeEach
    void setUp() {
        exampleService = new ExampleService();
    }

    @Test
    void getStylizedGreeting_ReturnsCorrectGreetingForValidChoice() {
        assertEquals("Howdy", exampleService.getStylizedGreeting(0));
        assertEquals("Hello", exampleService.getStylizedGreeting(2));
        assertEquals("Hola", exampleService.getStylizedGreeting(9));
    }

    @Test
    void getStylizedGreeting_ReturnsDefaultGreetingForNegativeChoice() {
        assertEquals("Howdy (Default)", exampleService.getStylizedGreeting(-1));
    }

    @Test
    void getStylizedGreeting_ReturnsDefaultGreetingForChoiceOutOfBounds() {
        assertEquals("Howdy (Default)", exampleService.getStylizedGreeting(10));
    }
}
