package com.crea.storage.dto;

public record ConvertErrorResponse(
        String message,
        int statusCode,
        String sourceFile,
        String targetFile,
        String targetFormat
) {
}
