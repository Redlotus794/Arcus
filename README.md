# Arucs
命名由来：闪之轨迹黎恩所在的7班是以运用新型战术导力器“亚克斯（アークス，ARCUS）”为名义而实验性设立的特别班。



## 项目地址

- Github: [Arcus](https://github.com/Redlotus794/Arucs)
- 项目架构图: [系统架构图](https://www.processon.com/diagraming/6847bf19590f390f1b036cc1)



## 背景

本项目是一个基于多编程语言环境，实验性的项目。旨在探索和实现不同编程语言的能力。  
项目基于GNU General Public License v3.0（GPL-3.0）协议。  



## 硬件（我的Mac）

- Processor: 2.6 GHz 6-Core Intel Core i7
- Graphics: 
  - AMD Radeon Pro 5500M 8 GB
  - Intel UHD Graphics 630 1536 MB
- Memory: 32 GB 2667 MHz DDR4
- SSD



## 基础设施

- **操作系统**: MacOS Sonoma 14.2.1

- **容器编排管理**: 

  - Kubesphere v3.3.2 

  ```shell
  # Check kubectl
  > kubectl version
  Client Version: v1.32.2
  Kustomize Version: v5.5.0
  Server Version: v1.32.2
  
  # 查看 KubeSphere 相关的 Pod 是否都在运行。可以通过下面的命令来列出 KubeSphere 命名空间中的 Pod，并检查它们的状态：
  > kubectl get pods -n kubesphere-system
  NAME                                     READY   STATUS    RESTARTS      AGE
  ks-apiserver-cd6d4fdf5-mqf4j             1/1     Running   0             15h
  ks-console-bbfbb6d9f-22h2t               1/1     Running   0             15h
  ks-controller-manager-76d9bc4fd4-jv25j   1/1     Running   1 (15h ago)   15h
  ks-installer-5d7b75dc6-zclnl             1/1     Running   3 (42h ago)   7d15h
  
  > kubectl get pods -n kubesphere-monitoring-system
  NAME                                  READY   STATUS    RESTARTS       AGE
  kube-state-metrics-69dc6fb84c-l6m2h   3/3     Running   12 (42h ago)   7d15h
  node-exporter-dvwvn                   2/2     Running   0              21h
  prometheus-k8s-0                      2/2     Running   6 (42h ago)    7d15h
  prometheus-operator-db99c75c5-9t2wx   2/2     Running   9 (42h ago)    7d15h
  
  # 访问 KubeSphere 控制台
  > kubectl get svc/ks-console -n kubesphere-system
  NAME         TYPE       CLUSTER-IP       EXTERNAL-IP   PORT(S)        AGE
  ks-console   NodePort   10.109.177.140   <none>        80:30880/TCP   7d20h
  
  # 默认的地址
  http://localhost:30880
  ```

  - Helm 

  ```shell
  > helm version
  version.BuildInfo{Version:"v3.18.2", GitCommit:"04cad4610054e5d546aa5c5d9c1b1d5cf68ec1f8", GitTreeState:"clean", GoVersion:"go1.24.3"}
  ```

    

- **数据库**: 

  数据库采用本地docker部署的形式，

  - MySQL 8.0.34 
  ```yaml
  mysql:
  	host: localhost
  	port: 3308
  ```

  - MySQL 5.7

  ```yaml
  mysql:
  	host: localhost
  	port: 3307
  ```

  - Redis 7

  ```yaml
  redis: 
  	host: localhost
  	port: 6380
  ```

  - MongoDB 6

  ```yaml
  mongodb:
  	host: localhost
  	port: 27017
  ```

  

## 技术栈使用

根据不同项目的内容来选择不同的编程语言和技术栈。  
参考各项目的`README.md` 文件。



## 项目列表

- JDK Feature - [README.md](jdk-features/README.md)
- Leetcode - [README.md](leetcode/README.md)
- Spring Cloud Alibaba KubeSphere - [README.md](spring-cloud-alibaba-kubesphere/README.md)