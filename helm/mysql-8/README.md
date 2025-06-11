# helm 安装 mysql 8
```shell
helm repo add bitnami https://charts.bitnami.com/bitnami
helm repo update

cd helm/mysql-8
helm install arcus-mysql-8 bitnami/mysql -f values.yaml --namespace arcus
kubectl apply -f nodeport.yaml
```
