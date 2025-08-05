# FAQ

# Dubbo

### Dubbo的注册地址为什么会是26.26.26.1

```text
26.26.26.1是来自本机的虚拟接口，是因为打开了代理软件（letsvpn）导致的。
dubbo默认会排除回环地址(127.0.0.1)，最终选择第一个符合条件的非回环地址ip。

这个地址会导致dubbo中的MetaDataService无法访问，导致调用rpc服务失败。
可以通过手动指定dubbo.protocol.host的方式解决这个问题。
```
