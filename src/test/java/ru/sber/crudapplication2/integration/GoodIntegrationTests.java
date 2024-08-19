package ru.sber.crudapplication2.integration;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import ru.sber.crudapplication2.GoodRepository;
import ru.sber.crudapplication2.entity.Good;

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
    protected MockMvc http;

    /**
     * Репозиторий для работы с {@link Good}.
     */
    @Autowired
    protected GoodRepository goodRepository;

    /**
     * После каждого теста удаляет тестовые данные.
     */
    @AfterEach
    void clearDatabase() {
        goodRepository.deleteAll();
    }
}
