package com.myylm.common.CacheLimit;

import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.RateLimiter;
import com.myylm.ExceptionHandler.ServiceException;
import com.myylm.Utils.IPUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import com.google.common.cache.CacheBuilder;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@Aspect
@Configuration
public class CacheLimitAspect {
    //根据IP分不同的令牌桶, 每天自动清理缓存
    private static LoadingCache<String, RateLimiter> caches = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(1, TimeUnit.DAYS)
            .build(new CacheLoader<String, RateLimiter>() {
                @Override
                public RateLimiter load(String key) {
                    // 新的IP初始化 每秒只发出5个令牌
                    return RateLimiter.create(5);
                }
            });

    //Service层切点  限流
    @Pointcut("@annotation(com.myylm.common.CacheLimit.CacheLimit)")
    public void ServiceAspect() {

    }

    @Around("ServiceAspect()")
    public  Object around(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        CacheLimit limitAnnotation = method.getAnnotation(CacheLimit.class);
        CacheLimit.LimitType limitType = limitAnnotation.limitType();
        String key = limitAnnotation.key();
        Object obj = null;
        try {
            if(limitType.equals(CacheLimit.LimitType.IP)){
                key = IPUtils.getIpAddr();
            }
            RateLimiter rateLimiter = caches.get(key);
            Boolean flag = rateLimiter.tryAcquire();
            if(flag){
                obj = joinPoint.proceed();
            }else{
                throw new ServiceException("访问太频繁了");
            }
        } catch (Throwable e) {
            try {
                throw new ServiceException("访问太频繁了");
            } catch (ServiceException e1) {
                e1.printStackTrace();
            }
        }
        return obj;
    }

}
