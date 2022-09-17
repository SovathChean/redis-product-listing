package com.sovathc.redisproductlisting.core.dto;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash("CategoryDTO")
public class CategoryDTO {
    private String id;
    private String name;
}
