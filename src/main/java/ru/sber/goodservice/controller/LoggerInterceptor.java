package ru.sber.goodservice.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Реализация {@link HandlerInterceptor} для логирования обработки запросов в контроллерах.
 *
 * @author Ivan Andrianov.
 */
@Slf4j
public class LoggerInterceptor implements HandlerInterceptor {

    /**
     * Логирует начало выполнения метода обработчика запроса.
     *
     * @param request  текущий http-запрос.
     * @param response текущий http-ответ.
     * @param handler  обработчик запроса.
     * @return true, если перехватчик пропускает поток выполнения в метод обработчик, иначе - false.
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.debug("[preHandle][{}][{}]{}", request, request.getMethod(), request.getRequestURI());
        return true;
    }

    /**
     * Логирует окончание выполнения метода обработчика запроса.
     *
     * @param request  текущий http-запрос.
     * @param response текущий http-ответ.
     * @param handler  обработчик запроса.
     * @param modelAndView - возвращаемое представление.
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        log.debug("[postHandle][{}]", request);
    }
}
