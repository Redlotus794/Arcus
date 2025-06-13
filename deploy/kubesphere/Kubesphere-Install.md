# 安装 Kubesphere

https://www.kubesphere.io/zh/docs/v4.1/02-quickstart/01-install-kubesphere/

## helm 安装
```shell
helm upgrade --install -n kubesphere-system --create-namespace ks-core https://charts.kubesphere.io/main/ks-core-1.1.4.tgz --debug --wait
```