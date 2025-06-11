# Kubesphere的安装组件

## nacos-k8s
https://github.com/nacos-group/nacos-k8s Quick Start Nacos in K8s

### helm部署
- 关键配置项调整（针对 KubeSphere）
```yaml
namespace: spring-cloud-alibaba-kubesphere # Namespace for Nacos deployment.

persistence:
  enabled: true
  data:
    accessModes:
      - ReadWriteOnce
    storageClassName: manual  # KubeSphere 默认存储类，需根据实际修改
    resources:
      requests:
        storage: 5Gi
        
resources:
  requests:
    cpu: 500m
    memory: 1Gi
```
- helm install
```shell
cd nacos-k8s/helm
helm install nacos-k8s ./ --namespace arcus 
```
