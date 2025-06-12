# 🧪 Spring Cloud Alibaba 微服务框架测试项目(基于Kubesphere)
本项目旨在使用 KubeSphere 搭建一个本地测试环境，部署基于 Spring Cloud Alibaba 的微服务架构，并进行 并发性能测试。

# 📌 目标
- 使用 KubeSphere 部署 Spring Cloud Alibaba 微服务架构。
- 实现服务注册与发现、配置中心、网关、限流熔断等功能。
- 模拟高并发请求场景，验证系统在压力下的稳定性与性能表现。

# 🧩 技术栈
| Component             | Version                   | Description                          | Deployment |
|-----------------------|---------------------------|--------------------------------------|-----------------------|
| KubeSphere            | v4.1.3                    | Container platform management tool   | Arcus基础设施 |
| Kubernetes            | v1.32.2                   | Container orchestration engine       | Arcus基础设施 |
| Spring Boot           | 3.2.4                     | Microservices base framework         | Spring   |
| Spring Cloud          | 2023.0.1                  | Microservices architecture support   | Spring |
| [Spring Cloud Alibaba](https://sca.aliyun.com/en/) | 2023.0.1.0                | Provides Nacos, Sentinel, etc.       | Spring |
| Nacos                 | 3.0.1                | Service registry & config center     | k8s/nacos |
| Sentinel              | 1.8.6                     | Traffic control & circuit breaking   |    |
| Gateway               | Spring Cloud Gateway      | API gateway                         |                          |
| Load Testing Tool     | Apache JMeter / wrk / hey | Concurrency testing tools            |             |
| MySQL | 8.0.34 | MySQL数据库 | Arcus基础设施 |
| Redis | 7 |  |  |
| MongoDB | 6 |  |  |

# 📦 项目结构
```
spring-cloud-alibaba-kubesphere/
├── config-center/              # Common configuration files
├── service-a/                  # Example business service A
├── service-b/                  # Example business service B
├── gateway/                    # API gateway service
├── k8s/                        # Kubernetes resource definitions
│   ├── nacos/									# Nacos Standalone mode 
│   ├── sentinel/
│   └── services/
├── src/                        # Java 源代码目录
│   ├── main/
│   		├── resources/          # 资源目录
│						├── init-sql/       # 项目初始化sql
├── README.md
└── pom.xml
```

# 🔧 环境准备
- 测试机： MacOS Sonoma 14.2.1
- 配置: Docker Desktop 4CPU / 16GB 内存 / 1.5GB Swap / 128GB SSD
- Docker 启动K8S组件，安装 KubeSphere
  - **node-exporter 会因为MacOS底层目录权限问题无法正常运行，需手动修改配置文件**
- Helm (curl https://raw.githubusercontent.com/helm/helm/main/scripts/get-helm-3 | bash)
- GraalVM 编译

# 常用Web页和命令

- 快速开始

  ```shell
  chmod 777 quick-start-macos.sh
  ./quick-start-macos.sh 
  ./quick-start-macos.sh delete
  ```

  

- Nacos 控制台 : http://127.0.0.1:30001/

# 🚀 部署步骤

- 创建命名空间（已创建可以跳过）
```shell
kubectl create namespace arcus
```
- 初始化

```
SQL : /src/main/resources/init-sql
```

- 安装 Nacos

````
kubectl apply -f nacos-arcus.yaml
kubectl apply -f nacos-arcus-nodeport.yaml
````


# 🧪 并发测试方案
### 工具选择
Apache JMeter / hev / wrk

### 测试目标
- 最大并发数：100 ~ 1000
- 观察 QPS、响应时间、错误率等指标
- 验证 Sentinel 的限流策略是否生效

# 📊 性能监控
通过以下方式观察服务运行状况：

- SkyWalking（可选）：接入可观测性数据（分布式追踪、日志、指标）
- Prometheus + Grafana：监控服务 CPU、内存、QPS 等指标
- KubeSphere 控制台：查看 Pod、Service、Deployment 状态

# 📝 注意事项
- 修改 application.yml 中的服务注册地址为 K8s 内部 Service 地址（如 nacos-headless）。
- 若使用本地开发调试，请注意网络互通问题。
- 建议为每个服务设置资源限制（CPU/Memory），避免资源争抢。
- 压测时请关注服务日志和 Sentinel 控制台中的限流情况。

# 📚 参考文档
- [KubeSphere 官方文档](https://kubesphere.io/docs/)
- [Spring Cloud Alibaba 文档](https://alibaba.github.io/spring-cloud-alibaba/)
- [Nacos 文档](https://nacos.io/zh-cn/docs/)
- [Sentinel 文档](https://sentinelguard.io/zh-cn/docs/)
- [Spring Cloud Gateway 文档](https://cloud.spring.io/spring-cloud-gateway/reference/html/)
- [Apache JMeter 文档](https://jmeter.apache.org/)

# 💡 结语
该项目可用于学习如何在 KubeSphere 上部署 Spring Cloud Alibaba 微服务架构，并验证其在高并发场景下的表现。欢迎提交 Issue 或 PR 来改进此项目！