package com.sovathc.redisproductlisting.web.vo.response;

import lombok.Data;

@Data
public class ResponseMessage<T> {
    private String resultCode;
    private String resultMesssage;
    private Boolean result;
    private T body;
}
