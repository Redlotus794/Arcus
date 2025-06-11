# 部署问题

### 0/1 nodes are available: pod has unbound immediate PersistentVolumeClaims. preemption: 0/1 nodes are available: 1 Preemption is not helpful for scheduling.
 解决方案:

```plaintext
删除root相关目录的挂载
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
```
