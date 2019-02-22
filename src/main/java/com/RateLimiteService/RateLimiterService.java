package com.RateLimiteService;

import com.commons.Constant;
import com.google.common.util.concurrent.RateLimiter;
import org.springframework.context.annotation.Configuration;

public class RateLimiterService {
    private static RateLimiter limiter = RateLimiter.create(Constant.LIMITE_RATE);

    public static boolean tryToken(){
        synchronized (RateLimiterService.class) {
            while (!limiter.tryAcquire()){
            }
            return true;
        }
    }

    public static void acquireToken(){
        limiter.acquire();
    }
}
