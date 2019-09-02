package com.myylm.commons.aop.LogAop;

import java.lang.annotation.*;

/**
 * @desc 日志注解
 * @author hmmzhtx
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoggerManage {
    public String logDescription();
}
