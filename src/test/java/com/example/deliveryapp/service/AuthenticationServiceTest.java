package com.example.deliveryapp.service;

import static com.example.deliveryapp.BaseTest.getContentFromFile;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.example.deliveryapp.BaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
public class AuthenticationServiceTest extends BaseTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void authTest() throws Exception {
        var request = post("/admin").contentType(MediaType.APPLICATION_JSON).content(getContentFromFile("?"));

        mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());

    }
}
