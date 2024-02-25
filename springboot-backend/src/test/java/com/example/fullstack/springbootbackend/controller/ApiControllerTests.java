package com.example.fullstack.springbootbackend;

import com.example.fullstack.springbootbackend.controller.ApiController;
import com.example.fullstack.springbootbackend.dto.ApiResponse;
import com.example.fullstack.springbootbackend.service.ExampleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Unit tests
@ExtendWith(MockitoExtension.class)
public class ApiControllerTests {

    @Mock
    private ExampleService exampleService;

    @InjectMocks
    private ApiController apiController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(apiController).build();
    }

    @Test
    public void sayHello_ReturnsHowdyPartner() throws Exception {
        mockMvc.perform(get("/api/hello"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'message':'Howdy Partner!','success':true}"));
    }

    @Test
    public void getGreeting_WithChoice_ReturnsCustomGreeting() throws Exception {
        when(exampleService.getStylizedGreeting(1)).thenReturn("Hello, World!");
        mockMvc.perform(get("/api/greeting").param("choice", "1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'message':'Hello, World!','success':true}"));
    }
}

// Integration tests
@ExtendWith(SpringExtension.class)
@WebMvcTest(ApiController.class)
class ApiControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExampleService exampleService;

    @Test
    public void integrationTest_getGreeting_ReturnsServiceResponse() throws Exception {
        when(exampleService.getStylizedGreeting(0)).thenReturn("Default Greeting");

        mockMvc.perform(get("/api/greeting").param("choice", "0"))
                .andExpect(status().isOk())
                .andExpect(content().json("{'message':'Default Greeting','success':true}"));
    }
}
