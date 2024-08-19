package ru.sber.crudapplication2.integration;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import ru.sber.crudapplication2.entity.Good;
import ru.sber.crudapplication2.entity.enums.GoodCategory;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("Интеграционные тесты получения информации о товаре")
public class ReadGoodIntegrationTests extends GoodIntegrationTests {

    /**
     * Тестовый товар.
     */
    private Good testGood;

    /**
     * Тестовый товар в Json-формате.
     */
    private String testGoodJson;

    /**
     * Маппер, переводящий объекты в Json-формат и обратно.
     */
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Добавляет тестовые данные в базу данных.
     */
    @SneakyThrows
    @BeforeEach
    void addTestDataInDatabase() {
        testGood = goodRepository.save(new Good(
                null,
                5000.00,
                "Ball",
                GoodCategory.TOY
        ));
        testGoodJson = objectMapper.writeValueAsString(testGood);
    }

    @Test
    @SneakyThrows
    @DisplayName("Тестирует получение информации о товаре при корректном запросе")
    public void testReadGood_whenRequestIsCorrect_thenReturnStatus200() {
        http.perform(get("/api/v1/good/" + testGood.getId()))
                .andExpect(status().isOk())
                .andExpect(content().json(testGoodJson));
    }

    @Test
    @SneakyThrows
    @DisplayName("Тестирует получение информации о товаре при отсутствии id товара")
    public void testReadGood_whenIdIsNotInPath_thenReturnStatus200() {
        http.perform(get("/api/v1/good/"))
                .andExpect(status().isNotFound());
    }
}
