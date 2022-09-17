package com.sovathc.redisproductlisting.core.dto;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@RedisHash("Product")
public class ProductDTO implements Serializable {
    private static final long serialVersionUID = -3425495397311352807L;

    private String id;
    private String name;
    private String description;
}
