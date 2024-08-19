package ru.sber.goodservice.integration;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.sber.goodservice.entity.Good;
import ru.sber.goodservice.entity.enums.GoodCategory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("Интеграционные тесты удаления товара")
public class DeleteGoodIntegrationTests extends GoodIntegrationTests {

    /**
     * Тестовый товар.
     */
    private Good testGood;

    /**
     * Добавляет тестовые данные в базу данных.
     */
    @BeforeEach
    void addTestDataInDatabase() {
        testGood = goodRepository.save(new Good(
                null,
                5000.00,
                "Ball",
                GoodCategory.TOY
        ));
    }

    @Test
    @SneakyThrows
    @DisplayName("Тестирует удаление товара при корректном запросе")
    public void testDeleteGood_whenRequestIsCorrect_thenReturnStatus200() {
        final String expected = """
                {
                    "message":"Товар успешно удален"
                }
                """;

        http.perform(delete("/api/v1/good/" + testGood.getId()))
                .andExpect(status().isOk())
                .andExpect(content().json(expected));
        assertThat(goodRepository.findAll()).hasSize(0);
    }

    @Test
    @SneakyThrows
    @DisplayName("Тестирует удаление товара при пустой таблице goods")
    public void testDeleteGood_whenDatabaseIsEmpty_thenReturnStatus201() {
        goodRepository.deleteAll();
        final String expected = """
                {
                    "message":"Товар успешно удален"
                }
                """;

        http.perform(delete("/api/v1/good/" + testGood.getId()))
                .andExpect(status().isOk())
                .andExpect(content().json(expected));
        assertThat(goodRepository.findAll()).hasSize(0);
    }

    @Test
    @SneakyThrows
    @DisplayName("Тестирует удаление товара при отсутствии id товара в запросе")
    public void testDeleteGood_whenIdIsNotInParams_thenReturnStatus201() {
        goodRepository.deleteAll();

        http.perform(delete("/api/v1/good/"))
                .andExpect(status().isNotFound());
        assertThat(goodRepository.findAll()).hasSize(0);
    }
}
