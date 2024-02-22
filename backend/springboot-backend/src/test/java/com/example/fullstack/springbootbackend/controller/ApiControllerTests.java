package com.example.fullstack.springbootbackend.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ApiControllerTests {

    private static final String INFO_TEST_MESSAGE = "[API] /hello endpoint hit.";

    @Mock
    Logger logger;

    @InjectMocks
    ApiController apiController;

    @SuppressWarnings("null")
    @Test
    public void testSayHello200() {

        // Call the controller method
        ResponseEntity<Object> response = apiController.sayHello();

        Mockito.verify(logger).info(INFO_TEST_MESSAGE);
        Mockito.verifyNoMoreInteractions(logger);

        // Check if the response status is OK
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Check if the response body contains the expected message
        @SuppressWarnings("unchecked")
        Map<String, Object> responseBody = (Map<String, Object>) response.getBody();
        assertEquals("Howdy Partner!", responseBody.get("message"));
    }
}
