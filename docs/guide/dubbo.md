# Dubbo 用户指南

本指南将帮助你在项目中快速开始使用 Apache Dubbo。 

官方网站： [Dubbo 官方文档](https://cn.dubbo.apache.org/zh-cn/overview/what/)

## 1. 什么是 Dubbo？
Dubbo 是一个高性能的、基于 Java 的开源 RPC 框架。它为分布式系统提供服务注册、发现和治理能力。

## 2. 前置条件
- JDK 8 及以上
- Maven 或 Gradle
- Zookeeper（作为注册中心，或可用 Nacos/etcd）

## 3. 添加 Dubbo 依赖
在你的 `pom.xml` 中添加如下依赖：

```xml
<dependency>
    <groupId>org.apache.dubbo</groupId>
    <artifactId>dubbo-spring-boot-starter</artifactId>
    <version>3.3.0</version>
</dependency>

<!-- 如果使用 Zookeeper 作为注册中心 -->
<dependency>
    <groupId>org.apache.curator</groupId>
    <artifactId>curator-framework</artifactId>
    <version>5.5.0</version>
</dependency>

<!-- 如果使用 Nacos 作为注册中心 -->
<dependency>
    <groupId>org.apache.dubbo</groupId>
    <artifactId>dubbo-nacos-spring-boot-starter</artifactId>
</dependency>
```

## 4. 基本配置
在你的 `application.yaml` 或 `application.properties` 中：

```yaml
# nacos/zookeeper 注册中心配置
spring:
  dubbo:
    application:
      name: demo-provider
      qos-enable: true # 启用 Dubbo QoS, 可以通过终端访问服务状态
      qos-port: 29001
      qos-accept-foreign-ip: false
      logger: slf4j
    registry:
      address: nacos://${nacos_host}:8848
      register-mode: instance
      parameters.namespace: arcus
    #registry:
    #  address: zookeeper://127.0.0.1:2181 # zookeeper
    protocol:
      name: dubbo
      port: 20880
```

## 5. 定义服务接口

Arcus的dubbo接口定义在arcus-dubbo-registry项目中

```java
public interface GreetingService {
    String sayHello(String name);
}
```

## 6. 实现服务
```java
@DubboService
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}
```

## 7. 延迟加载Service机制

Dubbo官方鼓励使用ReferenceBean来延迟加载服务，这样可以避免在应用启动时加载所有服务，减少启动时间。

```java
@Configuration
public class DubboReferenceConfig {
    @Bean
    @DubboReference
    public ReferenceBean<ArcusUserDubboService> arcusUserDubboService() {
        return new ReferenceBean();
    }
}
```

## 8. Dubbo Admin控制台安装

```shell
# 拉取最新版本镜像（推荐 0.5+ 版本，适配 Dubbo 3.x）
docker pull apache/dubbo-admin:latest

# 启动容器，指定注册中心地址（以 Nacos 为例）
docker run -d \
  -p 6001:8080 \  # 映射端口（宿主端口:容器端口）
  -e admin.registry.address=nacos://127.0.0.1:8848 \  # 注册中心地址
  -e admin.config-center=nacos://127.0.0.1:8848 \    # 配置中心地址（与注册中心一致即可）
  -e admin.metadata-report.address=nacos://127.0.0.1:8848 \  # 元数据中心地址
  --name dubbo-admin \
  apache/dubbo-admin:latest
```
