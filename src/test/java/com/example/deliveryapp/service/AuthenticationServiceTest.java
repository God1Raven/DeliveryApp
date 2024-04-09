package com.example.deliveryapp.service;

import com.example.deliveryapp.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class AuthenticationServiceTest extends BaseTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void authTest() throws Exception {
        // var request =
        // post("/admin").contentType(MediaType.APPLICATION_JSON).content(getContentFromFile("?"));
        //
        // mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }
}
