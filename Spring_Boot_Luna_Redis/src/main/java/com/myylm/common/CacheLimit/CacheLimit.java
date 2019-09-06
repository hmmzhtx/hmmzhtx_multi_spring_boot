package com.myylm.common.CacheLimit;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CacheLimit {
    /**
     * 描述
     */
    String description()  default "";

    /**
     * key
     */
    String key() default "limit";

    /**
     * 类型
     */
    LimitType limitType() default LimitType.CUSTOMER;

    enum LimitType {
        /**
         * 自定义key
         */
        CUSTOMER,
        /**
         * 根据请求者IP
         */
        IP
    }
}
