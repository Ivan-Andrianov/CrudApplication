package ru.sber.goodservice.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.sber.goodservice.dto.CreateGoodRequest;
import ru.sber.goodservice.dto.GoodDto;
import ru.sber.goodservice.dto.SuccessResponse;
import ru.sber.goodservice.dto.UpdateGoodRequest;
import ru.sber.goodservice.entity.Good;

import java.util.UUID;

/**
 * Контроллер для обработки запросов, связанных с {@link Good}.
 *
 * @author Ivan Andrianov.
 */
@RequestMapping("/api/v1/good")
public interface GoodController {

    /**
     * Создает новый товар.
     *
     * @param request запрос на создание товара.
     * @return сообщение об успешном выполнении запроса на создание товара.
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    SuccessResponse create(@Valid @RequestBody CreateGoodRequest request);

    /**
     * Удаляет товар.
     *
     * @param id идентификатор товара.
     * @return сообщение об успешном выполнении запроса на удаление товара.
     */
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    SuccessResponse delete(@PathVariable("id") UUID id);

    /**
     * Выдает информацию о товаре.
     *
     * @param id идентификатор товара.
     * @return информацию о товаре.
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    GoodDto read(@PathVariable("id") UUID id);

    /**
     * Обновляет товар.
     *
     * @param request запрос на обновление товара.
     * @return сообщение об успешном выполнении запроса на обновление товара.
     */
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    SuccessResponse update(@Valid @RequestBody UpdateGoodRequest request);
}
