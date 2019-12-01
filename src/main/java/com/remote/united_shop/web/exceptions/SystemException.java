package com.remote.united_shop.web.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class SystemException {
    protected int code;
    protected String message;
    public abstract String  handleError();
}

