package com.remote.united_shop.Core.Exceptions;

public class FailedToSaveDataException extends Exception {
    /***
     *
     * @param message
     * @param cause
     */
    public FailedToSaveDataException(String message, Throwable cause) {
        super(message, cause);
    }

    /***
     *
     * @param message
     */
    public FailedToSaveDataException(String message) {
        super(message);
    }
}
