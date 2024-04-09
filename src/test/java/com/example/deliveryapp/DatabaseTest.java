package com.example.deliveryapp;

import com.github.database.rider.spring.api.DBRider;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@DBRider
@Testcontainers
public class DatabaseTest extends BaseTest {

    @Container
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:16.2")
            .withUsername("postgres");

    @DynamicPropertySource
    public static void changeConfiguration(DynamicPropertyRegistry registry) {
        registry.add("spring.datasourceutils.url", () -> postgreSQLContainer.getJdbcUrl() + "&stringtype=unspecified");
        registry.add("spring.datasourceutils.username", postgreSQLContainer::getUsername);
        registry.add("spring.datasourceutils.password", postgreSQLContainer::getPassword);
    }

}
