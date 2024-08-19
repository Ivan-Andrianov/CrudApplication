package ru.sber.goodservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.sber.goodservice.entity.enums.GoodCategory;

import java.util.UUID;

/**
 * Товар.
 *
 * @author Ivan Andrianov.
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
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
    double price;

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
