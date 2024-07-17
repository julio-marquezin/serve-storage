package com.crea.storage.controller;

import com.crea.storage.dto.ConvertErrorResponse;
import com.crea.storage.dto.FTPConnectionErrorResponse;
import com.crea.storage.dto.FTPDisconnectErrorResponse;
import com.crea.storage.dto.FTPOperationErrorResponse;

import com.crea.storage.exception.FTPConnectionException;
import com.crea.storage.exception.FTPDisconnectException;
import com.crea.storage.exception.FTPOperationException;
import com.crea.storage.exception.FileConverterException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(FileConverterException.class)
    public ResponseEntity<ConvertErrorResponse> convertFile(FileConverterException e) {
        ConvertErrorResponse errorResponse = new ConvertErrorResponse(
                e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                e.getSourceFile(),
                e.getTargetFile(),
                e.getTargetFormat()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler(FTPConnectionException.class)
    public ResponseEntity<FTPConnectionErrorResponse> ftpConnection(FTPConnectionException e) {
        FTPConnectionErrorResponse errorResponse = new FTPConnectionErrorResponse(
                e.getMessage(),
                HttpStatus.SERVICE_UNAVAILABLE.value(),
                e.getHost(),
                e.getUsername()
        );
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(errorResponse);
    }

    @ExceptionHandler(FTPOperationException.class)
    public ResponseEntity<FTPOperationErrorResponse> ftpOperation(FTPOperationException e) {
        FTPOperationErrorResponse errorResponse = new FTPOperationErrorResponse(
                e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler(FTPDisconnectException.class)
    public ResponseEntity<FTPDisconnectErrorResponse> ftpDisconnect(FTPDisconnectException e) {
        FTPDisconnectErrorResponse errorResponse = new FTPDisconnectErrorResponse(
                e.getMessage(),
                HttpStatus.SERVICE_UNAVAILABLE.value(),
                e.getHost()
        );
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(errorResponse);
    }

}
