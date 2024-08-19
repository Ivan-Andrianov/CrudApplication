package ru.sber.crudapplication2.service;

import org.springframework.web.bind.annotation.PathVariable;
import ru.sber.crudapplication2.dto.SuccessResponse;
import ru.sber.crudapplication2.entity.Good;

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
