package ru.sber.goodservice.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sber.goodservice.GoodRepository;
import ru.sber.goodservice.dto.SuccessResponse;
import ru.sber.goodservice.entity.Good;
import ru.sber.goodservice.service.GoodService;

import java.util.UUID;

/**
 * Сервис, содержащий бизнес логику для работы с {@link Good}.
 *
 * @author Ivan Andrianov.
 */
@Service
@RequiredArgsConstructor
public class GoodServiceImpl implements GoodService {

    /**
     * Репозиторий для работы с {@link Good}.
     */
    private final GoodRepository goodRepository;

    @Override
    @Transactional
    public SuccessResponse create(Good good) {
        goodRepository.save(good);
        return new SuccessResponse("Товар успешно создан");
    }

    @Override
    @Transactional
    public SuccessResponse delete(UUID id) {
        goodRepository.deleteById(id);
        return new SuccessResponse("Товар успешно удален");
    }

    @Override
    public Good read(UUID id) {
        return goodRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    @Transactional
    public SuccessResponse update(Good good) {
        int updates = goodRepository.updateGood(good);
        if (updates == 0) {
            throw new EntityNotFoundException();
        }
        return new SuccessResponse("Товар успешно обновлен");
    }
}
