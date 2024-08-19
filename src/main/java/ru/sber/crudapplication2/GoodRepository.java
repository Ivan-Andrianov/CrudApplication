package ru.sber.crudapplication2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.sber.crudapplication2.entity.Good;

import java.util.UUID;

/**
 * Spring Data Jpa репозиторий для работы с сущностью {@link Good}.
 *
 * @author Ivan Andrianov.
 */
public interface GoodRepository extends JpaRepository<Good, UUID> {

    /**
     * Обновляет {@link Good}. Обновляет только заданные поля, null игнорирует.
     *
     * @param good обновляемый товар.
     * @return количество обновлений.
     */
    @Modifying
    @Query("""
        UPDATE Good SET
            name = COALESCE(:#{#good.name}, name),
            price = CASE WHEN (:#{#good.price}=0) THEN price ELSE :#{#good.price} END,
            category = COALESCE(:#{#good.category}, category)
        WHERE id = :#{#good.id}""")
    int updateGood(Good good);
}
