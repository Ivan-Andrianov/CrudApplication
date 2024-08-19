package ru.sber.goodservice.dto;

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
    @JsonProperty("message")
    private String message;
}
