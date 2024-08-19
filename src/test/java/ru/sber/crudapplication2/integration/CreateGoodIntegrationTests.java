package ru.sber.crudapplication2.integration;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@DisplayName("Интеграционные тесты создания товара")
class CreateGoodIntegrationTests extends GoodIntegrationTests {

    @Test
    @SneakyThrows
    @DisplayName("Тестирует создание товара при корректном запросе")
    public void testCreateGood_whenRequestIsCorrect_thenReturnStatus201() {
        final String body = """
                    {
                        "name":"Ball",
                        "price":5000.00,
                        "category":"TOY"
                    }
                """;
        final String expected = """
                {
                    "message":"Товар успешно создан"
                }
                """;
        http.perform(post("/api/v1/good")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(body))
                .andExpect(status().isCreated())
                .andExpect(content().json(expected));
        assertThat(goodRepository.findAll()).hasSize(1);
    }

    @Test
    @SneakyThrows
    @DisplayName("Тестирует создание товара с пустым именем")
    public void testCreateGood_whenNameIsEmpty_thenReturnStatus400() {
        final String body = """
                    {
                        "name":" ",
                        "price":5000.00,
                        "category":"TOY"
                    }
                """;
        final String expected = """
                {
                    "message":"Некорректный запрос"
                }
                """;
        http.perform(post("/api/v1/good")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(body))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(expected));
        assertThat(goodRepository.findAll()).hasSize(0);
    }

    @Test
    @SneakyThrows
    @DisplayName("Тестирует создание товара с null именем")
    public void testCreateGood_whenNameIsNull_thenReturnStatus400() {
        final String body = """
                    {
                        "price":5000.00,
                        "category":"TOY"
                    }
                """;
        final String expected = """
                {
                    "message":"Некорректный запрос"
                }
                """;
        http.perform(post("/api/v1/good")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(body))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(expected));
        assertThat(goodRepository.findAll()).hasSize(0);
    }

    @Test
    @SneakyThrows
    @DisplayName("Тестирует создание товара с отрицательной ценой")
    public void testCreateGood_whenPriceIsNegative_thenReturnStatus400() {
        final String body = """
                    {
                        "name":"Ball",
                        "price":-5000.00,
                        "category":"TOY"
                    }
                """;
        final String expected = """
                {
                    "message":"Некорректный запрос"
                }
                """;
        http.perform(post("/api/v1/good")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(body))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(expected));
        assertThat(goodRepository.findAll()).hasSize(0);
    }

    @Test
    @SneakyThrows
    @DisplayName("Тестирует создание товара с несуществующей категорией")
    public void testCreateGood_whenCategoryIsUnknown_thenReturnStatus400() {
        final String body = """
                    {
                        "name":"Ball",
                        "price":5000.00,
                        "category":"UNKNOWN"
                    }
                """;
        final String expected = """
                {
                    "message":"Некорректный запрос"
                }
                """;
        http.perform(post("/api/v1/good")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(body))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(expected));
        assertThat(goodRepository.findAll()).hasSize(0);
    }

    @Test
    @SneakyThrows
    @DisplayName("Тестирует создание товара при запросе с лишними полями")
    public void testCreateGood_whenRequestHasExtraFields_thenReturnStatus400() {
        final String body = """
                    {
                        "id":"SOMEID"
                        "name":"Ball",
                        "price":5000.00,
                        "category":"TOY"
                    }
                """;
        final String expected = """
                {
                    "message":"Некорректный запрос"
                }
                """;
        http.perform(post("/api/v1/good")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(body))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(expected));
        assertThat(goodRepository.findAll()).hasSize(0);
    }

    @Test
    @SneakyThrows
    @DisplayName("Тестирует создание товара при запросе с пустым телом")
    public void testCreateGood_whenRequestBodyIsEmpty_thenReturnStatus400() {
        final String body = "{}";
        final String expected = """
                {
                    "message":"Некорректный запрос"
                }
                """;
        http.perform(post("/api/v1/good")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(body))
                .andExpect(status().isBadRequest())
                .andExpect(content().json(expected));
        assertThat(goodRepository.findAll()).hasSize(0);
    }

}
