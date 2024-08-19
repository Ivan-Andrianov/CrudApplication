package ru.sber.crudapplication2.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.sber.crudapplication2.entity.Good;
import ru.sber.crudapplication2.entity.enums.GoodCategory;

import java.util.UUID;

/**
 * Запрос на обновление {@link Good}.
 *
 * @author Ivan Andrianov.
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateGoodRequest {

    /**
     * Идентификатор товара.
     */
    @NotNull
    @JsonProperty("id")
    UUID id;

    /**
     * Цена товара.
     */
    @PositiveOrZero
    @JsonProperty("price")
    double price;

    /**
     * Имя товара.
     */
    @Pattern(regexp = "[a-zA-Z]{2,36}")
    @JsonProperty("name")
    String name;

    /**
     * Категория товара.
     */
    @JsonProperty("category")
    GoodCategory category;
}
