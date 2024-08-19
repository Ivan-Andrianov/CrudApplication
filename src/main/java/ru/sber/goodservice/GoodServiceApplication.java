package ru.sber.goodservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Точка запуска приложения.
 *
 * @author Ivan Andrianov.
 */
@SpringBootApplication
public class GoodServiceApplication {

    /**
     * Запускает приложение.
     *
     * @param args аргументы командной строки.
     */
    public static void main(String[] args) {
        SpringApplication.run(GoodServiceApplication.class, args);
    }
}
