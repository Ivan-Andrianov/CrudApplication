package ru.sber.goodservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.sber.goodservice.entity.Good;
import ru.sber.goodservice.entity.enums.GoodCategory;

/**
 * Запрос на создание {@link Good}.
 *
 * @author Ivan Andrianov.
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateGoodRequest {

    /**
     * Цена товара.
     */
    @Positive
    @JsonProperty(value = "price", required = true)
    double price;

    /**
     * Имя товара.
     */
    @NotNull
    @Pattern(regexp = "[a-zA-Z]{2,36}")
    @JsonProperty(value = "name")
    String name;

    /**
     * Категория товара.
     */
    @NotNull
    @JsonProperty(value = "category")
    GoodCategory category;
}
