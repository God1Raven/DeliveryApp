package com.example.deliveryapp.rest;

import com.example.deliveryapp.repository.AdminRepository;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc(printOnlyOnFailure = false)
@DataSet(value = {"data_sets/DATA_SET.json"})
@ExpectedDataSet(value = {"data_sets/DATA_SET.json"})
public class AdminControllerIT {
//    @Autowired
//    MockMvc mockMvc;
//    @Spy
//    AdminRepository adminRepository;
//    @Test
//    public void createAdmin(){
//        //given
//       MockMvcRequestBuilders.post("/admin/crete").
//               with(jwt().jwt(builder -> builder.claim("scope", "")));

        //when


        //then


//    }

}
