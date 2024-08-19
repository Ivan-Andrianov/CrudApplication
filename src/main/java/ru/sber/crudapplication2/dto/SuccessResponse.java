package ru.sber.crudapplication2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Ответ на успешно обработанный запрос.
 *
 * @author Ivan Andrianov.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SuccessResponse {

    /**
     * Сообщение.
     */
    @JsonProperty("successMessage")
    private String message;
}
