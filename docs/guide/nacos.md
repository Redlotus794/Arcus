# Nacos User Guide

Arcus Nacos 的用户指导文档。Nacos 是一个易于使用的动态服务发现、配置和服务管理平台，适用于云原生应用。

## Nacos 环境

| 环境            | 端口信息 |      |
| --------------- | -------- | ---- |
| local （docker) | 8848     |      |
|                 |          |      |
|                 |          |      |


## 应用服务

### maven引入
```xml
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
</dependency>

```

### spring-boot配置文件
```yaml
spring:
  cloud:
    nacos:
      discovery:
        server-addr: ${nacos_host}:8848
        namespace: ${nacos_namespace}
        register-enabled: true  
```
### Spring Boot应用启用发现配置
```java
@SpringBootApplication
@EnableDiscoveryClient
public class ArcusIdentityApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArcusIdentityApplication.class, args);
    }
}
```