package com.sovathc.redisproductlisting.core.dto;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash("ProductDTO")
public class ProductDTO {
    private String id;
    private String name;
    private String description;
}
