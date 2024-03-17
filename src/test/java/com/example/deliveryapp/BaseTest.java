package com.example.deliveryapp;

import com.example.deliveryapp.configuration.IntegractionTestConfiguration;
import com.example.deliveryapp.configuration.JunitTestConfiguration;
import com.example.deliveryapp.security.Role;
import com.example.deliveryapp.security.User;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;


@SpringBootTest(classes = {IntegractionTestConfiguration.class, JunitTestConfiguration.class})
@ActiveProfiles("test")
public class BaseTest {
    User user = new User(1L, "test", "test", "test@gmail.com", Role.CLIENT);



    public static String getContentFromFile(final String fileName) {
        try {
            try (InputStream inputStream = DatabaseTest.class.getResourceAsStream(fileName)) {
                if (inputStream == null) {
                    return null;
                }
                return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            }
        } catch (final IOException e) {
            throw new RuntimeException("Unable to open file", e);
        }
    }


}
