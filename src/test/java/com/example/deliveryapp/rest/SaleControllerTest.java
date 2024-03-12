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
@AutoConfigureMockMvc(printOnlyOnFailure = false) // Обязательная аннотация
@DataSet(value = {"data_sets/DATA_SET.json"})
@ExpectedDataSet(value = {"data_sets/DATA_SET.json"})
public class SaleControllerTest extends DatabaseTest {
    private final int port;
    @Autowired
    MockMvc mockMvc;


    public SaleControllerTest(@Value("${server.port}") int port) {
        this.port = port;
    }
    @Test
    public void findSaleByAddressTest() throws Exception {
        final String request = getContentFromFile("/Request/SaleRequest.json");
        final String response = getContentFromFile("/Response/SaleResponse.json");

        Assertions.assertNotNull(request, "Not found resource for request");
        Assertions.assertNotNull(response, "Not found resource for response");


        final var requestBuilder = MockMvcRequestBuilders
                .post("/sale/findSaleByAddress")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request);


        mockMvc
                .perform(requestBuilder)
                .andExpectAll(
                        status().isOk(),
                        content().json(response)
                );
        //TODO сделать метод, в который сразу подаешь респонс и реквест, что бы уменьшить код
        //Assertions.assertNotNull(client, "{\"id\": \"52\", \"address\": \"Kiseleva\", \"d.25\", \"kv.48\", \"shopId\": \"240\", \"shopName\": \"Магазин_42\"}");
    }
}
