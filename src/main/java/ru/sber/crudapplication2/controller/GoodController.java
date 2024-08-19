package ru.sber.crudapplication2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.sber.crudapplication2.dto.CreateGoodRequest;
import ru.sber.crudapplication2.dto.GoodDto;
import ru.sber.crudapplication2.dto.SuccessResponse;
import ru.sber.crudapplication2.dto.UpdateGoodRequest;
import ru.sber.crudapplication2.entity.Good;

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
    SuccessResponse create(CreateGoodRequest request);

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
    @GetMapping("/{id}")
    GoodDto read(@PathVariable("id") UUID id);

    /**
     * Обновляет товар.
     *
     * @param request запрос на обновление товара.
     * @return сообщение об успешном выполнении запроса на обновление товара.
     */
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping
    SuccessResponse update(UpdateGoodRequest request);
}
