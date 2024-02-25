package com.example.fullstack.springbootbackend;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class SpringbootBackendApplicationTests {

    @Test
    void contextLoads() {
        // This test ensures the Spring context loads successfully
    }

    @Test
    void applicationStarts() {
        // This test will cover the main method by calling it directly
        // We're passing an empty array of arguments because typically
        // the main method doesn't use them in a simple Spring Boot application
        SpringbootBackendApplication.main(new String[]{});
    }
}
