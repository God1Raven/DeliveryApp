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
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc(printOnlyOnFailure = false)
@DataSet(value = {"data_sets/PRODUCT.json", "data_sets/ORDER_PRODUCT.json", "data_sets/SHOP.json", "data_sets/SHOP_RATING.json",
        "data_sets/SALE.json", "data_sets/CLIENT.json", "data_sets/COURIER.json"})
@ExpectedDataSet(value = {"data_sets/PRODUCT.json", "data_sets/ORDER_PRODUCT.json", "data_sets/SHOP.json", "data_sets/SHOP_RATING.json",
        "data_sets/SALE.json", "data_sets/CLIENT.json", "data_sets/COURIER.json"})
public class CourierControllerTest extends DatabaseTest {

    private final int port;
    @Autowired
    MockMvc mockMvc;


    public CourierControllerTest(@Value("${server.port}")int port) {this.port = port;}

    @Test
    public void findCourierByProductTest() throws Exception {
        final String request = getContentFromFile("/Request/CourierRequest.json"); //Сделать метод где просто подаешь
        final String response = getContentFromFile("/Response/CourierResponse.json");

        Assertions.assertNotNull(request, "Not found resource for request");
        Assertions.assertNotNull(response, "Not found resource for response");


        final var requestBuilder = MockMvcRequestBuilders
                .post("/courier/findCourierByProduct")
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
