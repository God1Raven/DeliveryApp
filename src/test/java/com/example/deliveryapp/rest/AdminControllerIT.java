package com.example.deliveryapp.rest;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc(printOnlyOnFailure = false)
@DataSet(value = {"data_sets/DATA_SET.json"})
@ExpectedDataSet(value = {"data_sets/DATA_SET.json"})
public class AdminControllerIT {
    // @Autowired
    // MockMvc mockMvc;
    // @Spy
    // AdminRepository adminRepository;
    // @Test
    // public void createAdmin(){
    // //given
    // MockMvcRequestBuilders.post("/admin/crete").
    // with(jwt().jwt(builder -> builder.claim("scope", "")));

    // when

    // then

    // }

}
