package com.example.fullstack.springbootbackend.service;

import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    public String getStylizedGreeting(int choice) {
        String[] greetings = {
            "Howdy",
            "Hey there",
            "Hello",
            "Hiya",
            "Greetings",
            "Salutations",
            "Yo",
            "What's up",
            "Ahoy",
            "Hola"
        };

        // Ensure the choice is within the bounds of the greetings array
        if (choice < 0 || choice >= greetings.length) {
            return "Howdy (Default)"; // Default greeting if the choice is out of bounds
        }

        return greetings[choice];
    }
}
