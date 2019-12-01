package com.remote.united_shop.web.exceptions;

public class ErrorException extends SystemException{

    public ErrorException(int code, String message) {
        super(code, message);
    }

    @Override
    public String handleError() {
        return this.message;
    }
}
