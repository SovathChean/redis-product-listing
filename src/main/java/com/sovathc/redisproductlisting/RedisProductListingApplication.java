package com.sovathc.redisproductlisting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisProductListingApplication {

	public static void main(String[] args) {

		SpringApplication.run(RedisProductListingApplication.class, args);
	}

}
