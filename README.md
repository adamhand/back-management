## 商品后台管理系统

## 环境

- jdk1.8
- springboot 1.5.1
- mybatis 2.0.0
- mysql 8.0
- mysql-connector-java 8.0.11
- idea 2018

## 功能
Spring boot+Mybatis+thymeleaf+bootstrap。使用令牌桶进行一级限流；使用RabbitMQ进行流量削峰；使用Redis实现缓存。

参考
[Spring boot Mybatis 整合（完整版）](https://blog.csdn.net/Winter_chen001/article/details/77249029)

[springboot Mybatis 整合](https://blog.csdn.net/Winter_chen001/article/details/80010967)

遇到的问题：
整合完成时候，启动项目没有出现任何错误，但是发送请求时却出现下列错误：

```
Whitelabel Error Page
This application has no explicit mapping for /error, so you are seeing this as a fallback.

Fri Jan 25 14:37:12 CST 2019
There was an unexpected error (type=Not Found, status=404).
No message available
```

原来是因为Application启动类的位置不对，要将Application类放在最外侧,即包含所有子包。原因是spring-boot会自动加载启动类所在包下及其子包下的所有组件。

参考[异常:This application has no explicit mapping for /error, so you are seeing this as a fallback.](https://www.cnblogs.com/lilinzhiyu/p/7921890.html)

