package ru.sber.crudapplication2.controller.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.sber.crudapplication2.controller.GoodController;
import ru.sber.crudapplication2.dto.CreateGoodRequest;
import ru.sber.crudapplication2.dto.GoodDto;
import ru.sber.crudapplication2.dto.SuccessResponse;
import ru.sber.crudapplication2.dto.UpdateGoodRequest;
import ru.sber.crudapplication2.entity.Good;
import ru.sber.crudapplication2.mapper.GoodMapper;
import ru.sber.crudapplication2.service.GoodService;

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
     * Маппер для сущности {@link Good}
     */
    private final GoodMapper goodMapper;

    @Override
    public SuccessResponse create(CreateGoodRequest request) {
        SuccessResponse response = goodService.create(goodMapper.toEntity(request));
        return response;
    }

    @Override
    public SuccessResponse delete(UUID id) {
        SuccessResponse response = goodService.delete(id);
        return response;
    }

    @Override
    public GoodDto read(UUID id) {
        Good good = goodService.read(id);
        return goodMapper.toDto(good);
    }

    @Override
    public SuccessResponse update(UpdateGoodRequest request) {
        SuccessResponse response = goodService.update(goodMapper.toEntity(request));
        return response;
    }
}
