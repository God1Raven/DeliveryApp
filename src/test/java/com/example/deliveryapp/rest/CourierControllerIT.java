package com.example.deliveryapp.rest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.deliveryapp.DatabaseTest;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc(printOnlyOnFailure = false)
@DataSet(value = {"data_sets/DATA_SET.json"})
@ExpectedDataSet(value = {"data_sets/DATA_SET.json"})
@WithMockUser(username = "admin", roles = {"CLIENT", "ADMIN"})
public class CourierControllerIT extends DatabaseTest {

    private final int port;
    @Autowired
    MockMvc mockMvc;

    public CourierControllerIT(@Value("${server.port}") int port) {
        this.port = port;
    }

    @Test
    public void findCourierByProductTest() throws Exception {
        final String request = getContentFromFile("/Request/CourierRequest.json"); // Сделать метод где просто подаешь
        final String response = getContentFromFile("/Response/CourierResponse.json");

        Assertions.assertNotNull(request, "Not found resource for request");
        Assertions.assertNotNull(response, "Not found resource for response");

        final var requestBuilder = MockMvcRequestBuilders.post("/courier/findCourierByProduct")
                .contentType(MediaType.APPLICATION_JSON).content(request);

        mockMvc.perform(requestBuilder).andExpectAll(status().isOk(), content().json(response));
    }
}
