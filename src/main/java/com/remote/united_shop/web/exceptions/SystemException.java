package com.remote.united_shop.web.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SystemException {
    private int code;
    private String message;
}

