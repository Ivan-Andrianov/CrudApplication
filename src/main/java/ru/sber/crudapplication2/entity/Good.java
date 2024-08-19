package ru.sber.crudapplication2.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.DynamicUpdate;
import ru.sber.crudapplication2.entity.enums.GoodCategory;

import java.util.UUID;

/**
 * Товар.
 *
 * @author Ivan Andrianov.
 */
@Getter
@Setter
@Entity
@DynamicUpdate
@NoArgsConstructor
@Table(name = "goods")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Good {

    /**
     * Идентификатор товара.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    UUID id;

    /**
     * Цена товара.
     */
    @Column(name = "price", nullable = false)
    long price;

    /**
     * Имя товара.
     */
    @Column(name = "name", nullable = false)
    String name;

    /**
     * Категория товара.
     */
    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.STRING)
    GoodCategory category;
}
