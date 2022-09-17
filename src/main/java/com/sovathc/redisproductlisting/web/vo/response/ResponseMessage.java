package com.sovathc.redisproductlisting.web.vo.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseMessage<T> {
    private String resultCode;
    private String resultMesssage;
    private Boolean result;
    private T body;
    private String resultMessage;
    private String traceId;
    private String error;
    @JsonIgnore
    private HttpStatus status;
    public ResponseMessage(){}
}
