package com.sovathc.redisproductlisting.core.common.exception;

import com.sovathc.redisproductlisting.core.common.type.SysHttpResultCode;
import com.sovathc.redisproductlisting.web.vo.response.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
public abstract class AbstractErrorHandler extends ResponseEntityExceptionHandler {

    @SuppressWarnings("unchecked")
    @Override
    protected ResponseEntity handleExceptionInternal(
            Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request)
    {
        super.handleExceptionInternal(ex, body, headers, status, request);
        if (ex instanceof HttpMessageNotReadableException)
            return handleBadRequestException((HttpMessageNotReadableException) ex, status);
        logger.error("Error internal 500{}", ex);

        return this.buildExceptionResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR, SysHttpResultCode.ERROR_500.getCode());
    }
    @ExceptionHandler()

    protected ResponseEntity<ResponseMessage<?>> handleBadRequestException(Exception ex, HttpStatus status)
    {
        return this.buildExceptionResponse(ex, HttpStatus.BAD_REQUEST, SysHttpResultCode.ERROR_400.getCode());
    }
    @ExceptionHandler(DataAccessException.class)
    protected ResponseEntity<ResponseMessage<?>> handleDataAccessException(DataAccessException ex) {
        logger.error("DataAccess exception: {}", ex);
        String message = "error cannot read or write data";
        if (ex instanceof DataIntegrityViolationException)
            message = "error cannot save data";
        else if (ex instanceof InvalidDataAccessApiUsageException)
            message = "error cannot read data";

        return buildExceptionResponseMessage(message, SysHttpResultCode.ERROR_400.getCode());
    }
    public ResponseEntity<ResponseMessage<?>> buildExceptionResponse(Exception ex, HttpStatus status, String resultCode)
    {
        ResponseMessage response = responseMessage(ex, status, resultCode);
        return new ResponseEntity<ResponseMessage<?>>(response, response.getStatus());
    }
    public ResponseMessage responseMessage(Exception ex, HttpStatus status, String resultCode)
    {
        status = (status == null)? HttpStatus.INTERNAL_SERVER_ERROR : status;
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setError(ex.getMessage());
        responseMessage.setResultMessage(ex.getLocalizedMessage());
        responseMessage.setResultCode(resultCode);

        return responseMessage;
    }
    public ResponseEntity<ResponseMessage<?>> buildExceptionResponseMessage(String message, String resultCode)
    {
        ResponseMessage response = new ResponseMessage();
        response.setError(message);
        response.setResultCode(resultCode);

        return new ResponseEntity<ResponseMessage<?>>(response, HttpStatus.BAD_REQUEST);
    }
}
