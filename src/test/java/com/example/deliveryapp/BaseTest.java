package com.example.deliveryapp;

import com.example.deliveryapp.configuration.IntegractionTestConfiguration;
import com.example.deliveryapp.configuration.JunitTestConfiguration;
import com.example.deliveryapp.security.Role;
import com.example.deliveryapp.security.User;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

@SpringBootTest(classes = {IntegractionTestConfiguration.class, JunitTestConfiguration.class})
@ActiveProfiles("test")
public class BaseTest {

    @Container
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:16.2")
            .withNetworkAliases("delivery-app-network").withUsername("postgres");

    @DynamicPropertySource
    public static void changeConfiguration(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", () -> postgreSQLContainer.getJdbcUrl() + "&stringtype=unspecified");
        registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
        registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
    }

    @BeforeAll
    public static void beforeAll() {
        postgreSQLContainer.start();
    }

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
