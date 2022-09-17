package com.sovathc.redisproductlisting.web.vo.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResponseBuilderMessage<T> {
    private final ResponseMessage<T> message = new ResponseMessage<>();

    public ResponseBuilderMessage<T> success() {
        this.message.setResult(true);
        this.message.setResultCode(HttpStatus.OK.toString());
        this.message.setResultMesssage("success");
        return this;
    }
    public ResponseBuilderMessage<T> fail()
    {
        this.message.setResult(false);
        this.message.setResultCode(HttpStatus.BAD_GATEWAY.toString());
        this.message.setResultMesssage("fail");
        return this;
    }
    public ResponseBuilderMessage<T> error(HttpStatus status, String error)
    {
        this.message.setError(error);
        this.message.setResultCode(status.toString());
        this.message.setResultMessage("fail");
        return this;
    }
    public ResponseBuilderMessage<T> addData(T data)
    {
        this.message.setBody(data);

        return this;
    }
    public ResponseBuilderMessage<T> addMessage(String message)
    {
        this.message.setResultMessage(message);
        return this;
    }
    public ResponseBuilderMessage<T> addStatus(HttpStatus status)
    {
        this.message.setStatus(status);
        return this;
    }

    public ResponseMessage<T> build()
    {
        return this.message;
    }

}
