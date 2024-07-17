package com.crea.storage.dto;

public record ErrorResponse(
        String message,
        int statusCode
) {
}
