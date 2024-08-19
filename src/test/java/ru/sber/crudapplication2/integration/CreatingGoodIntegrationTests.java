package ru.sber.crudapplication2.integration;

import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

@DisplayName("Интеграционные тесты создания товара")
class CreatingGoodIntegrationTests extends GoodIntegrationTests {

    /**
     * Тестовый HTTP-клиент.
     */
    @Autowired
    private MockMvc http;


}
