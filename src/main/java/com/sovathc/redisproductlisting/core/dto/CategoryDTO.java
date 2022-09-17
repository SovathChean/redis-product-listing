package com.sovathc.redisproductlisting.core.dto;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

@Data
public class CategoryDTO {
    private String id;
    private String name;
}
