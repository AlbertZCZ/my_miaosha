### 本项目为`https://github.com/qiurunze123/miaosha`本地测试版，已把对我没用的文件删除   

![互联网 Java 秒杀系统设计与架构](https://raw.githubusercontent.com/qiurunze123/imageall/master/miaoshashejitu.png)

[![Travis](https://img.shields.io/badge/language-Java-yellow.svg)](https://github.com/qiurunze123)

[功能说明](/docs/model-instructions.md)  
 
### 最初版本请下载 (https://pan.baidu.com/s/1sld8RBSvLe2q4gc-Z-fVAQ)
### 如果想先看dubbo + zk 了解请下载we-miaosha ，miaosha-order  为项目分离示例项目！会不断完善！此版本为springboot2.0+ 请使JDK1.8+
### start 维护 开始搭建 

> 软件环境 : 请选择稳定版 

![整体流程](https://raw.githubusercontent.com/qiurunze123/imageall/master/miaosha.png)

> 未来设计图 : 未来设计

![整体流程](https://raw.githubusercontent.com/qiurunze123/imageall/master/miaoshafuture.png)

> 软件环境 : mysql 数据库表设计

![整体流程](https://raw.githubusercontent.com/qiurunze123/imageall/master/miaoshasql.png)

>1.需注意 因为秒杀，大促，打折等活动进行频繁，所以需要单独建立秒杀_....表来管理否则会经常进行回归

>2.本sql只是进行模拟，现实情况比这个信息要复杂的多，你可以把它看作是一个简化版本的sql

>3.访问地址 http://localhost:8080/login/to_login

###  以下所有内容都已完成，但是因内容多需逐渐整理上传！ 专题的部分也会尽快上传更新！ 立个flag 半年内吧争取全部更新完！各位稍安勿躁！ 

###  [如要提交代码请先看--提交合并代码规范提交者的后面都会有署名方便大家问问题](/docs/code-criterion.md)

| ID | Problem  | Article | 
| --- | ---   | :--- |
| 000 |如何解决卖超问题 | [解决思路](/docs/code-solve.md) |
| 001 |如何对本项目进行jmeter压测 | [解决思路](/docs/jemter-solve.md) |
| 003 |全局异常处理拦截 |[解决思路](/docs/code-solve.md)  |
| 003 |页面级缓存thymeleafViewResolver |[解决思路](/docs/code-solve.md)  |
| 004 |对象级缓存redis🙋🐓 |[解决思路](/docs/code-solve.md)  |
| 005 |订单处理队列rabbitmq |[解决思路](/docs/code-solve.md)  |
| 006 |解决分布式session |[解决思路](/docs/code-solve.md)  |
| 007 |秒杀安全 -- 安全性设计 |[解决思路](/docs/code-solve.md)  |
| 008 |通用缓存key的封装采用什么设计模式 |[解决思路](/docs/code-solve.md)  |
| 009 |redis的库存如何与数据库的库存保持一致 |[解决思路](/docs/code-solve.md)  |
| 010 |为什么redis数量会减少为负数 |[解决思路](/docs/code-solve.md)  |
| 011 |为什么要单独维护一个秒杀结束标志 |[解决思路](/docs/code-solve.md)  |
| 012 |rabbitmq如何做到消息不重复不丢失即使服务器重启 |[解决思路](/docs/code-solve.md)  |
| 013 |为什么threadlocal存储user对象，原理 |[解决思路](/docs/code-solve.md)  |
| 014 |maven 隔离 |[解决思路](/docs/code-solve.md)  |
| 015 |服务降级--服务熔断(过载保护)(未更新)） |[解决思路](/docs/code-solve.md)  |
| 016 |redis 分布式锁实现方法 |[解决思路](/docs/code-solve.md)  |
| 017 |定时关单模拟与分布式锁(未更新文章--代码已更新) |[解决思路](/docs/time-close.md)  |
| 018 |tomcat配置和优化  |[解决思路]((/docs/tomcat-good.md))  |
| 018 |tomcat集群配置 |[解决思路](/docs/tomcat-group.md)  |
| 020 |Nginx优化（前端缓存） |[解决思路](/docs/ngnix-good.md)  |
| 021 |重点  *** RPC分布式补偿如何解决(已更新 两种写法) |[解决思路](/docs/code-rpc.md)   |
| 022 |分布式事物解决方案（已更新 -- 最新的思路和写法） |[解决思路](/docs/code-rpc.md)   |
| 023 |mysql主从复制思路及实操（未更新代码） |[解决思路](/docs/mysql-master-slave.md)   |
| 024 |如何进行分库分表 |[解决思路](/docs/mysql-master-slave.md)   |
| 025 |秒杀类似场景sql的写法注意事项有哪些？|[解决思路](/docs/mysql-master-slave.md)   |
| 026 |如何利用lua脚本进行操作限流与分布式锁（可保证原子性）？|[解决思路](/docs/redis-good.md)   |
| 027 |如何利用lua脚本进行分布式锁操作？|[解决思路](/docs/redis-good.md)   |
| 028 |网站访问统计实现？|[解决思路](/docs/code-solve.md)   |
| 028 |项目进行dubbo + zk 改造 (已完成dubbo嵌入--springboot 与dubbo结合xml版本)？|[解决思路](/docs/code-solve.md)   |
| 029 |dubbo客户端 dubbo-admin管理平台 搭建安装|[解决思路](/docs/dubbo-admin.md)   |
| 030 |如何利用dubbo 的mock 来进行服务降级本地伪装 ?? (有更好的方式进群@我)|[解决思路](/docs/dubbo-zk.md)   |
| 031 |*** 如何利用lua + redis  取代 nigix + lua 脚本进行分布式限流 (请看miaosha-2version) ？ *** |[解决思路](/docs/redis-good.md)   |
| 032 |多数据源配置 如何进行多数据源配置 |[解决思路](/docs/code-solve.md)   |


#### [分布式系统发展历程（已更新）](/docs/fenbushi.md)
#### [生产环境内存调优](/docs/jvm-goods.md)
#### [mybatis源码解析与使用--未更新](/docs/mybatis-code.md)
#### [redis 使用与进阶以及如何进行集群--已更新](/docs/redis-good.md)
#### [spring源码--未更新](/docs/redis-code.md)
#### [分布式治理框架-dubbo - zk - 解析--更新中](/docs/dubbo-zk.md)
#### [多线程分析以及三高多线程demo系统  ](https://github.com/qiurunze123/threadandjuc)
#### [微服务框架--未更新](/docs/redis-code.md)
-------------------------------------------------|
#### [mysql数据库优化及架构学习](/docs/mysql.md)
#####     [mysql数据库设计规范(已更新)](/docs/mysql.md)
#####     [mysql数据库设计实例(已更新)](/docs/mysql-1.md)
#####     [mysql数据库执行计划分析（已更新）](/docs/mysql-2.md)
#####     [mysql数据库备份和恢复(已更新)](/docs/mysql-3.md)
#####     [mysql数据库架构变迁(已更新)](/docs/mysql-3.md)
--------------------------------------------------|
#### [netty专题(已更新 by liuxiangyu)](/docs/netty.md)
#### [linux专题](/docs/linux.md)


