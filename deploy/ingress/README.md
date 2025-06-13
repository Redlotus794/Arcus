# 安装 Ingress Controller
```shell
 # 添加仓库
helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx
helm repo update

# 安装 Ingress Controller
helm install ingress-nginx ingress-nginx/ingress-nginx --namespace ingress-nginx --create-namespace

# 更新端口
helm upgrade ingress-nginx -n ingress-nginx -f values.yaml ingress-nginx/ingress-nginx

# 验证 Ingress Controller 是否安装成功
kubectl get svc -n ingress-nginx


```