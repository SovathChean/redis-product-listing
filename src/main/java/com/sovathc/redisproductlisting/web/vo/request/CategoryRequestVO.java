package com.sovathc.redisproductlisting.web.vo.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CategoryRequestVO {
    @NotNull
    private String name;
}
