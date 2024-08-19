package ru.sber.goodservice.service;

import org.springframework.web.bind.annotation.PathVariable;
import ru.sber.goodservice.dto.SuccessResponse;
import ru.sber.goodservice.entity.Good;

import java.util.UUID;

/**
 * Сервис для работы с товарами.
 *
 * @author Ivan Andrianov.
 */
public interface GoodService {

    /**
     * Создает новый товар.
     *
     * @param good товар.
     * @return сообщение об успешном выполнении запроса на создание товара.
     */
    SuccessResponse create(Good good);

    /**
     * Удаляет товар.
     *
     * @param id идентификатор товара.
     * @return сообщение об успешном выполнении запроса на удаление товара.
     */
    SuccessResponse delete(@PathVariable("id") UUID id);

    /**
     * Выдает информацию о товаре.
     *
     * @param id идентификатор товара.
     * @return информацию о товаре.
     */
    Good read(@PathVariable("id") UUID id);

    /**
     * Обновляет товар.
     *
     * @param good товар.
     * @return сообщение об успешном выполнении запроса на обновление товара.
     */
    SuccessResponse update(Good good);
}
