package ru.sber.goodservice.controller.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import ru.sber.goodservice.controller.GoodController;
import ru.sber.goodservice.dto.CreateGoodRequest;
import ru.sber.goodservice.dto.GoodDto;
import ru.sber.goodservice.dto.SuccessResponse;
import ru.sber.goodservice.dto.UpdateGoodRequest;
import ru.sber.goodservice.entity.Good;
import ru.sber.goodservice.mapper.GoodMapper;
import ru.sber.goodservice.service.GoodService;

import java.util.UUID;

/**
 * Контроллер для обработки запросов на изменение, создание, удаление, получение информации о товаре.
 *
 * @author Иван Андрианов.
 */
@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
public class GoodControllerImpl implements GoodController {

    /**
     * Сервис для работы с товарами.
     */
    private final GoodService goodService;

    /**
     * Маппер для сущности {@link Good}.
     */
    private final GoodMapper goodMapper;

    @Override
    public SuccessResponse create(CreateGoodRequest request) {
        return goodService.create(goodMapper.toEntity(request));
    }

    @Override
    public SuccessResponse delete(UUID id) {
        return goodService.delete(id);
    }

    @Override
    public GoodDto read(UUID id) {
        return goodMapper.toDto(goodService.read(id));
    }

    @Override
    public SuccessResponse update(UpdateGoodRequest request) {
        return goodService.update(goodMapper.toEntity(request));
    }
}
