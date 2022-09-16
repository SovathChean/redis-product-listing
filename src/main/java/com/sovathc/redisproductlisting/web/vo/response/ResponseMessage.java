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

    public ResponseMessage() {
    }

    public ResponseMessage<T> body(T body) {
        this.body = body;
        return this;
    }

    public ResponseMessage<T> status(HttpStatus status) {
        this.status = status;
        return this;
    }

    public ResponseMessage<T> error(String error) {
        this.error = error;
        return this;
    }

    public ResponseMessage<T> traceId(String traceId) {
        this.traceId = traceId;
        return this;
    }

    public static <T> ResponseMessage<T> success() {
        return success(HttpStatus.ACCEPTED.toString(), HttpStatus.ACCEPTED.getReasonPhrase());
    }

    public static <T> ResponseMessage<T> success(String code, String message) {
        return build(code, message, true, HttpStatus.OK);
    }

    public static <T> ResponseMessage<T> success(String code, String message, T body) {
        ResponseMessage<T> _this = build(code, message, true, HttpStatus.OK);
        _this.body = body;
        return _this;
    }

    public static <T> ResponseMessage<T> fail(String code, String message) {
        return build(code, message, false, HttpStatus.BAD_REQUEST);
    }

    public static <T> ResponseMessage<T> build(String code, String message, boolean result, HttpStatus status) {
        return build(code, message, result, status, null);
    }

    public static <T> ResponseMessage<T> build(String code, String message, boolean result, HttpStatus status, T body) {
        ResponseMessage<T> _this = new ResponseMessage<T>();
        _this.result = result;
        _this.resultCode = code;
        _this.resultMessage = message;
        _this.status = status;
        _this.body = body;
        return _this;
    }
}
