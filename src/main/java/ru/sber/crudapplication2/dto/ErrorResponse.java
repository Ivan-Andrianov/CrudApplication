package ru.sber.crudapplication2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Ответ с сообщением об ошибке.
 *
 * @author Ivan Andrianov.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    /**
     * Сообщение об ошибке.
     */
    @JsonProperty("errorMessage")
    private String message;
}


