package ru.sber.crudapplication2;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sber.crudapplication2.entity.Good;

import java.util.UUID;

/**
 * Spring Data Jpa репозиторий для работы с сущностью {@link Good}.
 *
 * @author Ivan Andrianov.
 */
public interface GoodRepository extends JpaRepository<Good, UUID> { }
