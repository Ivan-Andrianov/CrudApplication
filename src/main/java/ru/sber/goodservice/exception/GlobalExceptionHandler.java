package ru.sber.goodservice.exception;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.sber.goodservice.dto.ErrorResponse;

/**
 * Обработчик исключений, возникающих на этапе обработки запроса.
 *
 * @author Ivan Andrianov.
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Шаблон для логирования ошибки.
     */
    private final String ERROR_LOG_TEMPLATE = "[handleException][exception: {}]";

    /**
     * Сообщение при некорректном запросе.
     */
    private final String BAD_REQUEST_MESSAGE = "Некорректный запрос";

    /**
     * Сообщение при отсутствии искомого ресурса.
     */
    private final String NOT_FOUND_MESSAGE = "Ресурс не найден";

    /**
     * Обработчик исключения {@link DataIntegrityViolationException}.
     *
     * @param ex обрабатываемое исключение.
     * @return сообщение об ошибке.
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        log.error(ERROR_LOG_TEMPLATE, ex.getMessage());
        return new ErrorResponse(BAD_REQUEST_MESSAGE);
    }

    /**
     * Обработчик исключения {@link MethodArgumentNotValidException}.
     *
     * @param ex обрабатываемое исключение.
     * @return сообщение об ошибке.
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValidExceptionException(MethodArgumentNotValidException ex) {
        log.error(ERROR_LOG_TEMPLATE, ex.getMessage());
        return new ErrorResponse(BAD_REQUEST_MESSAGE);
    }

    /**
     * Обработчик исключения {@link HttpMessageNotReadableException}.
     *
     * @param ex обрабатываемое исключение.
     * @return сообщение об ошибке.
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        log.error(ERROR_LOG_TEMPLATE, ex.getMessage());
        return new ErrorResponse(BAD_REQUEST_MESSAGE);
    }

    /**
     * Обработчик исключения {@link EntityNotFoundException}.
     *
     * @param ex обрабатываемое исключение.
     * @return сообщение об ошибке.
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleEntityNotFoundException(EntityNotFoundException ex) {
        log.error(ERROR_LOG_TEMPLATE, ex.getMessage());
        return new ErrorResponse(NOT_FOUND_MESSAGE);
    }
}
