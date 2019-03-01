## 简单商品后台管理系统

## 环境和配置

- jdk1.8
- springboot 1.5.1
- mybatis 2.0.0
- mysql 8.0
- mysql-connector-java 8.0.11
- rabbitmq 3.6.5
- redis 3.2.1

## 功能
基于Spring boot的商品后台管理系统。使用redis做缓存，LRU缓存淘汰策略；使用RabbitMQ进行流量削峰，能够支持并发操作；使用MyBatis做持久层框架，MySQL做存储，并实现了MySQL的简单索引优化；使用thymeleaf+bootstrap实现一个简单前端界面。

## 简单演示



