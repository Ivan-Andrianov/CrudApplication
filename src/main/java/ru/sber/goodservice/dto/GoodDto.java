package ru.sber.goodservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.sber.goodservice.entity.Good;
import ru.sber.goodservice.entity.enums.GoodCategory;

import java.util.UUID;

/**
 * DTO для сущности {@link Good}.
 *
 * @author Ivan Andrianov.
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GoodDto {

    /**
     * Идентификатор товара.
     */
    @JsonProperty("id")
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
