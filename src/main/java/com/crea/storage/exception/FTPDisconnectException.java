package com.crea.storage.exception;

import lombok.Getter;

@Getter
public class FTPDisconnectException extends RuntimeException {

    private final String host;

    public FTPDisconnectException(Throwable cause, String message, String host) {
        super(message, cause);
        this.host = host;
    }

}
