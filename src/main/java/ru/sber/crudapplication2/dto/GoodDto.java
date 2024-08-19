package ru.sber.crudapplication2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.sber.crudapplication2.entity.Good;
import ru.sber.crudapplication2.entity.enums.GoodCategory;

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
