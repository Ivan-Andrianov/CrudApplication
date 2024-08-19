package ru.sber.goodservice.mapper;

import org.mapstruct.Mapper;
import ru.sber.goodservice.dto.CreateGoodRequest;
import ru.sber.goodservice.dto.GoodDto;
import ru.sber.goodservice.dto.UpdateGoodRequest;
import ru.sber.goodservice.entity.Good;

/**
 * Маппер для преобразования сущности {@link Good} в DTO и обратно.
 *
 * @author Ivan Andrianov.
 */
@Mapper(componentModel = "spring")
public interface GoodMapper {

    /**
     * Переводит {@link CreateGoodRequest} в {@link Good}.
     *
     * @param request запрос на создание пользователя.
     * @return товар.
     */
    Good toEntity(CreateGoodRequest request);

    /**
     * Переводит {@link UpdateGoodRequest} в {@link Good}.
     *
     * @param request запрос на обновление пользователя.
     * @return товар.
     */
    Good toEntity(UpdateGoodRequest request);

    /**
     * Переводит {@link Good} в {@link GoodDto}.
     *
     * @param good товар.
     * @return DTO товара.
     */
    GoodDto toDto(Good good);
}
