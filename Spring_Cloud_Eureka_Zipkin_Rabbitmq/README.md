##spring boot 2.0 之后版本的zipkin使用
### 前言
>使用EnableZipkinServer创建自定义的zipkin服务器已经被废弃，在官网中已经给出了完整的架包；对此我们直接使用即可
>可以使用rabbitmq、msql

##对zipkin-server启动，直接使用如下脚本：配置了RabbitMq，Mysql
```bat
::在Spring Boot 2.0之后，使用EnableZipkinServer创建自定义的zipkin服务器已经被废弃，在官网中已经给出了完整的架包，下载启动即可
::官网：https://zipkin.io/
::使用：先进行数据库表创建，sql语句：zipkin.sql
@ECHO OFF
set SERVER_PORT=9000
set RABBIT_ADDRESSES=192.168.20.198:5672
set RABBIT_USER=quna
set RABBIT_PASSWORD=123456
set RABBIT_VIRTUAhttp://peer1:3001/consumer_HelloL_HOST=quna-test
SET STORAGE_TYPE=mysql
SET MYSQL_HOST=localhost:3306
SET MYSQL_DB=zipkin
SET MYSQL_USER=root
SET MYSQL_PASS=root
::windows 10 64bit版本，默认参数启动zipkin server 会报错，Native memory allocation (malloc) failed to allocate 360816 bytes for Chunk::new
::需要增加ReservedCodeCacheSize大小
::linux shell暂未尝试
set JAVA_OPTS="-XX:ReservedCodeCacheSize=64m" 
java -jar zipkin-server-2.12.9-exec.jar
```

### 效果查看
>在项目中启动
>Spring_Cloud_Eureka_Server 注册中心

>Spring_Cloud_Eureka_Client 服务端口，也可以叫客户端
>>若是使用rabbitmq，引入model后，配置rabbit链接即可：（不使用，删除此模块）  
```xml
<dependency>
   <groupId>org.springframework.cloud</groupId>
   <artifactId>spring-cloud-starter-stream-rabbit</artifactId>
</dependency>
```

>Spring_Cloud_Eureka_Consumer_Feign 消费者，就是调用Spring_Cloud_Eureka_Client接口的服务端
>>若是使用rabbitmq，引入model,配置rabbit链接即可：（不使用，删除此模块）  
```xml
<dependency>
   <groupId>org.springframework.cloud</groupId>
   <artifactId>spring-cloud-starter-stream-rabbit</artifactId>
</dependency>
```

>Spring_Cloud_Eureka_Zipkin_Rabbitmq 内部内部使用脚本：run_zipkin_server.bat启动

>接口访问：http://peer1:3001/consumer_Hello

>RabbitMq访问：http://localhost:15672

>zipkin访问：http://localhost:9000/zipkin/

### 项目地址
[https://github.com/hmmzhtx/hmmzhtx_multi_spring_boot](https://github.com/hmmzhtx/hmmzhtx_multi_spring_boot)

