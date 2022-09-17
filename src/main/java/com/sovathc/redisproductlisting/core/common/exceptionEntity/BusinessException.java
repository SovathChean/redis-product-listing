package com.sovathc.redisproductlisting.core.common.exceptionEntity;

import lombok.Getter;

@Getter
public class BusinessException extends Exception{
    private String code;
    public BusinessException(String code, String message)
    {
        super(message);
        this.code = code;
    }
    public BusinessException(String code, String message, Throwable throwable)
    {
        super(message, throwable);
        this.code = code;
    }
    public BusinessException(String code, Throwable e)
    {
        super(e.getMessage(), e);
        this.code = code;
    }
}
