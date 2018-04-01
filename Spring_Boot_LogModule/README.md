## spring boot 日期模块
### 前言
> 对于我们任何系统来说，日志模块的集成是必不可少的，记录系统中我们所指定的信息（记录、错误、警告），对于之后我们的查看或者错误
分析都是起着至关重要的作用。

### 架包模块
> 这是使用log4j2模块，这里引入log4j2模块，需要剔除自带的logging模块
```$xslt
<!--web模块-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <exclusions>
        <!-- 剔除logging -->
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-logging</artifactId>
        </exclusion>
    </exclusions>
</dependency>

<!-- 添加Log4j -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-log4j2</artifactId>
</dependency>
```
### 日志等级(下面的配置会需要滴)
> //日志级别从低到高分为TRACE < DEBUG < INFO < WARN < ERROR < FATAL，如果设置为WARN，则低于WARN的信息都不会输出。

### 日志模块信息
> 对每个日志的类型，输入到指定的文件夹是我自己喜欢用的一种方式，这里我只记录了此一种方式。
> 在resources中新建“logback-boot.xml”文件，内容如下:
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<configuration scan="true" scanPeriod="60 seconds" debug="false">

    <!--设置变量-->
    <Property name="filename" value="hmmzhtx" />
    <Property name="package" value="A-logs/${filename}" />
    <Property name="info-log" value="${package}/${filename}-info.log"/>
    <Property name="warn-log" value="${package}/${filename}-warn.log"/>
    <Property name="sys-log" value="${package}/${filename}-sys.log"/>
    <Property name="error-log" value="${package}/${filename}-error.log"/>
    <Property name="maxHistory" value="365"/>


    <!-- RollingFileAppender：滚动记录文件，先将日志记录到指定文件，当符合某个条件时，将日志记录到其他文件 -->
    <!-- 以下的大概意思是：1.先按日期存日志，日期变了，将前一天的日志文件名重命名为XXX%日期%索引，新的日志仍然是当前日志 -->
    <!--             2.如果日期没有发生变化，但是当前日志的文件大小超过设定的大小时，对当前日志进行分割 重命名-->

    <!-- 系统详细信息-->
    <appender name="SYS_LOG" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>${sys-log}</file>
        <!-- 时间监听器 -->
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <!-- daily rollover -->
            <fileNamePattern>${sys-log}.%d{yyyy-MM-dd}.log</fileNamePattern>
            <maxHistory>${maxHistory}</maxHistory>
            <!--用来指定日志文件的上限大小，那么到了这个值，就会删除旧的日志-->
            <!--<totalSizeCap>1GB</totalSizeCap>-->
        </rollingPolicy>
        <encoder>
            <pattern>[%d{yyyy-MM-dd HH:mm:ss}] %-5level %logger{60}\(%L\) - %msg%n</pattern>
            <!-- 记录日志的编码 -->
            <charset>UTF-8</charset> <!-- 此处设置字符集 -->
        </encoder>
    </appender>


       <!-- 错误信息 -->
    <appender name="ERROR_LOG" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>${error-log}</file>
        <!-- 过滤日志级别 -->
        <filter class="ch.qos.logback.classic.filter.LevelFilter">
            <level>ERROR</level>
            <!--没有匹配到就允许-->
            <onMatch>ACCEPT</onMatch>
            <!--匹配到就禁止-->
            <onMismatch>DENY</onMismatch>
        </filter>
        <!-- 时间监听器 -->
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <!-- daily rollover -->
            <fileNamePattern>${error-log}.%d{yyyy-MM-dd}.log</fileNamePattern>
            <maxHistory>${maxHistory}</maxHistory>
            <!--用来指定日志文件的上限大小，那么到了这个值，就会删除旧的日志-->
            <!--<totalSizeCap>1GB</totalSizeCap>-->
        </rollingPolicy>
        <encoder>
            <pattern>[%d{yyyy-MM-dd HH:mm:ss}] %-5level %logger{60}\(%L\) - %msg%n</pattern>
            <!-- 记录日志的编码 -->
            <charset>UTF-8</charset> <!-- 此处设置字符集 -->
        </encoder>
    </appender>


    <!-- 警告信息 -->
    <appender name="WARN_LOG" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>${warn-log}</file>
        <!-- 过滤日志级别 -->
        <filter class="ch.qos.logback.classic.filter.LevelFilter">
            <level>WARN</level>
            <!--没有匹配到就允许-->
            <onMatch>ACCEPT</onMatch>
            <!--匹配到就禁止-->
            <onMismatch>DENY</onMismatch>
        </filter>
        <!--滚动策略，按照时间滚动 TimeBasedRollingPolicy-->
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <!--文件路径,定义了日志的切分方式——把每一天的日志归档到一个文件中,以防止日志填满整个磁盘空间-->
            <fileNamePattern>${warn-log}.%d{yyyy-MM-dd}.log</fileNamePattern>
            <maxHistory>${maxHistory}</maxHistory>
            <!--用来指定日志文件的上限大小，那么到了这个值，就会删除旧的日志-->
            <!--<totalSizeCap>1GB</totalSizeCap>-->
        </rollingPolicy>
        <encoder>
            <pattern>[%d{yyyy-MM-dd HH:mm:ss}] %-5level %logger{60}\(%L\) - %msg%n</pattern>
            <!-- 记录日志的编码 -->
            <charset>UTF-8</charset> <!-- 此处设置字符集 -->
        </encoder>
    </appender>



    <!-- 详情信息 -->
    <appender name="INFO_LOG" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>${info-log}</file>
        <!-- 过滤日志级别 -->
        <filter class="ch.qos.logback.classic.filter.LevelFilter">
            <level>INFO</level>
            <!--没有匹配到就允许-->
            <onMatch>ACCEPT</onMatch>
            <!--匹配到就禁止-->
            <onMismatch>DENY</onMismatch>
        </filter>
        <!--滚动策略，按照时间滚动 TimeBasedRollingPolicy-->
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <!--文件路径,定义了日志的切分方式——把每一天的日志归档到一个文件中,以防止日志填满整个磁盘空间-->
            <fileNamePattern>${info-log}.%d{yyyy-MM-dd}.log</fileNamePattern>
            <maxHistory>${maxHistory}</maxHistory>
            <!--用来指定日志文件的上限大小，那么到了这个值，就会删除旧的日志-->
            <!--<totalSizeCap>1GB</totalSizeCap>-->
        </rollingPolicy>
        <encoder>
            <pattern>[%d{yyyy-MM-dd HH:mm:ss}] %-5level %logger{60}\(%L\) - %msg%n</pattern>
            <!-- 记录日志的编码 -->
            <charset>UTF-8</charset> <!-- 此处设置字符集 -->
        </encoder>
    </appender>


    <!-- %m输出的信息,%p日志级别,%t线程名,%d日期,%c类的全名,%i索引【从数字0开始递增】,,, -->
    <!-- appender是configuration的子节点，是负责写日志的组件。 -->
    <!-- ConsoleAppender：把日志输出到控制台 -->
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>[%d{yyyy-MM-dd HH:mm:ss}] %-5level %logger{60}\(%L\) - %msg%n</pattern>
            <!-- 记录日志的编码 -->
            <charset>UTF-8</charset> <!-- 此处设置字符集 -->
        </encoder>
    </appender>

    <!-- 指定项目中某个包，当有日志操作行为时的日志记录级别 -->
    <!-- com.myylm为根包，也就是只要是发生在这个根包下面的所有日志操作行为 -->
    <!-- 级别依次为【从高到低】：FATAL > ERROR > WARN > INFO > DEBUG > TRACE  -->

    <!--错误日志-->
    <logger name="com.myylm" level="ERROR">
        <appender-ref ref="ERROR_LOG" />
    </logger>

    <!--警告日志-->
    <logger name="com.myylm" level="WARN">
        <appender-ref ref="WARN_LOG" />
    </logger>

    <!--信息日志-->
    <logger name="com.myylm" level="INFO">
        <appender-ref ref="INFO_LOG" />
    </logger>

    <!-- 控制台输出日志级别 -->
    <root level="INFO">
        <!-- 引用设置 -->
        <appender-ref ref="SYS_LOG" />
        <appender-ref ref="STDOUT" />
    </root>
</configuration>
```
### application 对日志模块引用
> 文件"application.properties"中添加：logging.config = classpath:logback-boot.xml
### 源码中使用
```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author hmmzhtx
 */
@Controller
public class LogController {

    public  static Logger logger = LoggerFactory.getLogger(LogController.class);

    @RequestMapping(value = "/logInfo")
    @ResponseBody
    public String logDo(){
        //日志级别从低到高分为TRACE < DEBUG < INFO < WARN < ERROR < FATAL，如果设置为WARN，则低于WARN的信息都不会输出。
        logger.trace("日志输出 trace");
        logger.debug("日志输出 debug");
        logger.info("日志输出 info");
        logger.warn("日志输出 warn");
        logger.error("日志输出 error");
        return "打印！！";
    }
}
```


