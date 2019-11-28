package com.remote.united_shop.Core.Exceptions;

public class FailedToSaveDataException extends Exception {
    public FailedToSaveDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public FailedToSaveDataException(String message) {
        super(message);
    }
}
