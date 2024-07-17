package com.crea.storage.dto;

public record FTPOperationErrorResponse (
        String message,
        int statusCode
) {
}
