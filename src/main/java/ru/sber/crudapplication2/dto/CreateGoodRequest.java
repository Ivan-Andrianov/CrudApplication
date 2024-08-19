package ru.sber.crudapplication2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.sber.crudapplication2.entity.Good;
import ru.sber.crudapplication2.entity.enums.GoodCategory;

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
    long price;

    /**
     * Имя товара.
     */
    @NotBlank
    @Pattern(regexp = "[a-zA-Z]{2,36}")
    @JsonProperty(value = "name", required = true)
    String name;

    /**
     * Категория товара.
     */
    @NotNull
    @JsonProperty(value = "category", required = true)
    GoodCategory category;
}
