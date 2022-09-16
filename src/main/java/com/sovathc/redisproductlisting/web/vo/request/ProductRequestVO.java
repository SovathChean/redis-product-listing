package com.sovathc.redisproductlisting.web.vo.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ProductRequestVO {
    @NotNull
    private String name;
    private String description;
}
