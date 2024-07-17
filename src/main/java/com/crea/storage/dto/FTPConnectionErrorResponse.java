package com.crea.storage.dto;

public record FTPConnectionErrorResponse(
        String message,
        int statusCode,
        String host,
        String username
) {
}
