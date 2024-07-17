package com.crea.storage.dto;

public record FTPDisconnectErrorResponse(
        String message,
        int statusCode,
        String host
) {
}
