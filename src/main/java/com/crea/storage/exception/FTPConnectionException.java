package com.crea.storage.exception;

import lombok.Getter;

@Getter
public class FTPConnectionException extends RuntimeException {

    private final String host;
    private final String username;

    public FTPConnectionException(Throwable cause, String message, String host, String username) {
        super(message, cause);
        this.host = host;
        this.username = username;
    }
}
