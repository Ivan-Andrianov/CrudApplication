package ru.sber.crudapplication2.integration;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import ru.sber.crudapplication2.entity.Good;
import ru.sber.crudapplication2.entity.enums.GoodCategory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("Интеграционные тесты удаления товара")
public class UpdateGoodIntegrationTests extends GoodIntegrationTests {

    /**
     * Тестовый товар.
     */
    private Good testGood;

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
    }

    @Test
    @SneakyThrows
    @DisplayName("Тестирует обновление информации о товаре при корректном запросе")
    public void testReadGood_whenRequestIsCorrect_thenReturnStatus200() {
        final String body = """
                    {
                        "id":"%s",
                        "name":"Doll"
                    }
                """.formatted(testGood.getId());
        final String expected = """
                {
                    "message":"Товар успешно обновлен"
                }
                """;

        http.perform(patch("/api/v1/good")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().json(expected));
        assertThat(goodRepository.findById(testGood.getId()).get().getName()).isEqualTo("Doll");
    }

    @Test
    @SneakyThrows
    @DisplayName("Тестирует обновление информации о несуществующем товаре")
    public void testReadGood_whenGoodIsNotFound_thenReturnStatus404() {
        final String body = """
                    {
                        "id":"57000217-f571-4a8a-919f-960b39e32bba",
                        "name":"Doll"
                    }
                """;
        final String expected = """
                {
                    "message":"Ресурс не найден"
                }
                """;

        http.perform(patch("/api/v1/good")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNotFound())
                .andExpect(content().json(expected));
    }

    @Test
    @SneakyThrows
    @DisplayName("Тестирует обновление информации о товаре при запросе, в теле которого есть только id товара")
    public void testReadGood_whenRequestIsEmptyButWithId_thenReturnStatus200() {
        final String body = """
                    {
                        "id":"%s"
                    }
                """.formatted(testGood.getId());
        final String expected = """
                {
                    "message":"Товар успешно обновлен"
                }
                """;

        http.perform(patch("/api/v1/good")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().json(expected));

        final Good actual = goodRepository.findById(testGood.getId()).get();
        assertAll(
                () -> assertThat(actual.getName()).isEqualTo(testGood.getName()),
                () -> assertThat(actual.getPrice()).isEqualTo(testGood.getPrice()),
                () -> assertThat(actual.getCategory()).isEqualTo(testGood.getCategory())
        );
    }

    @Test
    @SneakyThrows
    @DisplayName("Тестирует обновление информации о товаре при пустом запросе")
    public void testReadGood_whenRequestIsEmpty_thenReturnStatus400() {
        final String body = "{}";
        final String expected = """
                {
                    "message":"Некорректный запрос"
                }
                """;

        http.perform(patch("/api/v1/good")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(expected));
    }

    @Test
    @SneakyThrows
    @DisplayName("Тестирует обновление информации о товаре при отрицательной цене")
    public void testReadGood_whenPriceIsNegative_thenReturnStatus400() {
        final String body = """
                    {
                        "id":"%s",
                        "price":-6000.00
                    }
                """.formatted(testGood.getId());
        final String expected = """
                {
                    "message":"Некорректный запрос"
                }
                """;

        http.perform(patch("/api/v1/good")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(expected));
        Good actual = goodRepository.findById(testGood.getId()).get();
        assertAll(
                () -> assertThat(actual.getName()).isEqualTo(testGood.getName()),
                () -> assertThat(actual.getPrice()).isEqualTo(testGood.getPrice()),
                () -> assertThat(actual.getCategory()).isEqualTo(testGood.getCategory())
        );
    }

    @Test
    @SneakyThrows
    @DisplayName("Тестирует обновление информации о товаре при некорректном имени")
    public void testReadGood_whenNameIsNumber_thenReturnStatus400() {
        final String body = """
                    {
                        "id":"%s",
                        "name":123
                    }
                """.formatted(testGood.getId());
        final String expected = """
                {
                    "message":"Некорректный запрос"
                }
                """;

        http.perform(patch("/api/v1/good")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(expected));
        Good actual = goodRepository.findById(testGood.getId()).get();
        assertAll(
                () -> assertThat(actual.getName()).isEqualTo(testGood.getName()),
                () -> assertThat(actual.getPrice()).isEqualTo(testGood.getPrice()),
                () -> assertThat(actual.getCategory()).isEqualTo(testGood.getCategory())
        );
    }

    @Test
    @SneakyThrows
    @DisplayName("Тестирует обновление информации о товаре при несуществующей категории")
    public void testReadGood_whenCategoryIsIncorrect_thenReturnStatus400() {
        final String body = """
                    {
                        "id":"57000217-f571-4a8a-919f-960b39e32bba",
                        "category":"UNKNOWN"
                    }
                """;
        final String expected = """
                {
                    "message":"Некорректный запрос"
                }
                """;

        http.perform(patch("/api/v1/good")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(expected));

        Good actual = goodRepository.findById(testGood.getId()).get();
        assertAll(
                () -> assertThat(actual.getName()).isEqualTo(testGood.getName()),
                () -> assertThat(actual.getPrice()).isEqualTo(testGood.getPrice()),
                () -> assertThat(actual.getCategory()).isEqualTo(testGood.getCategory())
        );
    }
}
