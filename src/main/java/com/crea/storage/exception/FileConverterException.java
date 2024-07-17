package com.crea.storage.exception;

import lombok.Getter;

@Getter
public class FileConverterException extends RuntimeException {

    private final String sourceFile;
    private final String targetFile;
    private final String targetFormat;

    public FileConverterException(Throwable cause, String message, String sourceFile, String targetFile, String targetFormat) {
        super(message, cause);
        this.sourceFile = sourceFile;
        this.targetFile = targetFile;
        this.targetFormat = targetFormat;
    }

}
