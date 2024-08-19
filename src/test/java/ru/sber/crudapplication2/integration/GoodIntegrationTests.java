package ru.sber.crudapplication2.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Класс для хранения всей информации о поднимаемом контексте, чтобы не поднимать
 * для каждого тестового класса новый Spring-контекст.
 *
 * @author Ivan Andrianov.
 */
@DirtiesContext
@ActiveProfiles("test")
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class GoodIntegrationTests {

    /**
     * Тестовый http-клиент.
     */
    @Autowired
    private MockMvc http;
}
