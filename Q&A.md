# 部署问题

### failed to try resolving symlinks in path "/var/log/pods/kubesphere-monitoring-system_node-exporter-qbk82_9ab79b2c-8f79-4a1d-bc75-2cd0d47d62fa/node-exporter/48.log": lstat /var/log/pods/kubesphere-monitoring-system_node-exporter-qbk82_9ab79b2c-8f79-4a1d-bc75-2cd0d47d62fa/node-exporter/48.log: no such file or directory
 解决方案:
```plaintext
kubectl get daemonset node-exporter -n kubesphere-monitoring-system -o yaml > node-exporter-daemonset.yaml 
导出文件后，删除root相关目录的挂载
volumes:
  - hostPath:
	  path: /
	  type: ""
	name: root

volumeMounts:
	- mountPath: /host/root
	  mountPropagation: HostToContainer
	  name: root
	  readOnly: true

containers:
      - args:
      		- --path.rootfs=/host/root
      		
kubectl apply -f node-exporter-daemonset.yaml
```
