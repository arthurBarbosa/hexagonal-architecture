package com.arthurbarbosa.hexagonal.adapters.in.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    ResponseEntity<String> handleException(
            final HttpServletRequest request, final Exception exception
    ) {
        final var url = request.getRequestURL().toString();
        final var message = exception.getMessage();
        final var resultMessage = "Request: %s raised %s".formatted(url, message);

        LOGGER.error(resultMessage, exception);

        return ResponseEntity.status(500).body(resultMessage);
    }
}
