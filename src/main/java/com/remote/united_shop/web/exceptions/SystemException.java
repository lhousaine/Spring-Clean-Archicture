package com.remote.united_shop.web.exceptions;

public abstract class SystemException {
    protected int code;
    protected String message;

    public SystemException(int code, String message){
        this.code = code;
        this.message = message;
    }

    public void setCode(int code){
        this.code = code;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage(){
        return message;
    }

    public abstract String  handleError();
}

