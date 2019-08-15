::在Spring Boot 2.0之后，使用EnableZipkinServer创建自定义的zipkin服务器已经被废弃，在官网中已经给出了完整的架包，下载启动即可
::官网：https://zipkin.io/
::使用：先进行数据库表创建，sql语句：zipkin.sql
@ECHO OFF
set SERVER_PORT=9000
set RABBIT_ADDRESSES=192.168.20.198:5672
set RABBIT_USER=quna
set RABBIT_PASSWORD=123456
set RABBIT_VIRTUAL_HOST=quna-test
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

