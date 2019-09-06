package com.myylm.common.RedisLimit;

import com.myylm.ExceptionHandler.ServiceException;
import com.myylm.Utils.IPUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

@Aspect
@Configuration
public class LimitAspect {
    private static final Logger logger = LoggerFactory.getLogger(LimitAspect.class);

    @Autowired
    private RedisTemplate<String, Serializable> limitRedisTemplate;

    @Autowired
    private DefaultRedisScript<Number> redisluaScript;

    @Around("execution(* com.myylm.controller ..*(..) )")
    public Object interceptor(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Class<?> targetClass = method.getDeclaringClass();
        RateLimit rateLimit = method.getAnnotation(RateLimit.class);

        if (rateLimit != null) {
            String ipAddress = IPUtils.getIpAddr();

            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(ipAddress).append("-")
                    .append(targetClass.getName()).append("- ")
                    .append(method.getName()).append("-")
                    .append(rateLimit.key());

            List<String> keys = Collections.singletonList(stringBuffer.toString());

            Number number = limitRedisTemplate.execute(redisluaScript, keys, rateLimit.count(), rateLimit.time());

            if (number != null && number.intValue() != 0 && number.intValue() <= rateLimit.count()) {
                logger.info("限流时间段内访问第：{} 次", number.toString());
                return joinPoint.proceed();
            }

        } else {
            return joinPoint.proceed();
        }
        //由于本文没有配置公共异常类，如果配置可替换
        throw new ServiceException("访问太频繁了");
    }


}
