package com.sovathc.redisproductlisting.core.common.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SysHttpResultCode {
    SUCCESS("200", "Success"),
    ERROR_422("422", "The given data was invalid"),
    ERROR_400("400", "Invalid Request"),
    ERROR_404("404", "API is not found"),
    ERROR_500("500", "Internal Server Error");

    final String code;
    final String description;
}
