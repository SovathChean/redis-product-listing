package com.sovathc.redisproductlisting.core.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartUpListner implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private CacheManager cacheManager;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("On Application Event is OK");
        cacheManager.getCacheNames().parallelStream().forEach(n -> {
            // cacheManager.getCache(n).clear()
            System.out.println(n);
        });
    }
}
