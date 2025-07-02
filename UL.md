# Arcus Ubiquitous Language - UL 通用语言

## 正式

### DTO - Data Transfer Object 数据传输对象

DTO（Data Transfer Object）是一种设计模式，用于在软件系统的不同组件（如层、服务、进程或网络）之间传输数据。它的核心目的是减少网络请求中的数据传输量，或隔离业务逻辑与数据展示逻辑。

**定义**：DTO 是一个简单的 Java 对象（或其他语言中的类似对象），只包含数据字段及其 getter/setter 方法，不包含业务逻辑（区别于值对象）。

**作用**:

- 在不同层（如表现层、业务层、数据访问层）之间传输数据
- 在远程调用（如 REST API、RPC）中封装请求和响应数据
- 隐藏实体类的敏感信息或内部结构
- 优化数据传输，只包含必要字段



## 候选

## EJO - Entity Json Object 实际JSON对象

EJO（Entity Json Object）是 Arcus 中用于表示实体的 JSON 对象。  
它通常用于在实体和其对应的json表示之间进行转换。