package ru.sber.crudapplication2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.sber.crudapplication2.entity.enums.GoodCategory;

import java.util.UUID;

/**
 * Запрос на обновление товара.
 *
 * @author Ivan Andrianov.
 */
public class UpdateGoodRequest {

    /**
     * Идентификатор товара.
     */
    @JsonProperty(value = "id", required = true)
    UUID id;

    /**
     * Цена товара.
     */
    @JsonProperty("price")
    long price;

    /**
     * Имя товара.
     */
    @JsonProperty("name")
    String name;

    /**
     * Категория товара.
     */
    @JsonProperty("category")
    GoodCategory category;
}
