package com.example.deliveryapp.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.deliveryapp.BaseTest;
import com.example.deliveryapp.security.UserRepository;
import com.example.deliveryapp.security.UserService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@WithMockUser
@ContextConfiguration
@ExtendWith(MockitoExtension.class)
public class UserServiceTest extends BaseTest {
    @Autowired
    private UserService userService;
    @MockBean
    private UserRepository userRepository;
    @Autowired
    MockMvc mockMvc;

    @Test
    void createUser() {
    }

    @Test
    void deleteUser() {
    }
    @Test
    @WithMockUser(roles = "CLIENT")
    @Disabled
    public void securedEndpointTest() throws Exception {
        mockMvc.perform(get("/**")).andExpect(status().isOk());
    }
}
