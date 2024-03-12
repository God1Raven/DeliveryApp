package com.example.deliveryapp.rest;

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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc(printOnlyOnFailure = false)
@DataSet(value = {"data_sets/DATA_SET.json"})
@ExpectedDataSet(value = {"data_sets/DATA_SET.json"})
public class ProductControllerTest extends DatabaseTest {
    private final int port;

    @Autowired
    MockMvc mockMvc;

    public ProductControllerTest(@Value("${server.port}") int port) {
        this.port = port;
    }

    @Test
    public void findByDateSortByAvgRateTest() throws Exception {
        //given
        final String request = getContentFromFile("/Request/ProductRequest.json"); //Сделать метод где просто подаешь
        final String response = getContentFromFile("/Response/ProductResponse.json");

        Assertions.assertNotNull(request, "Not found resource for request");
        Assertions.assertNotNull(response, "Not found resource for response");


        final var requestBuilder = MockMvcRequestBuilders
                .post("/product/findByDateSortByAvgRate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request);


        mockMvc
                .perform(requestBuilder)
                .andExpectAll(
                        status().isOk(),
                        content().json(response)
                );
    }

}
