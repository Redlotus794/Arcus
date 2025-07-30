# Arcus Convention 

Arcus 项目的规范和约定旨在确保项目的内容遵循一致的风格和结构。 

## 目录

### Arcus Code Convention

#### ♨ Java

- [User Interface 用户接口层](./java/userinterface/README.md)
  - 
- Application Service 应用服务层
  - bootstrap/startup 启动项
  - command CQRS命令
  - impl 应用服务实现
  - job/schedule 定时任务
  - payload 数据载荷对象(可以省略)
    - dmto 领域模型传输对象
    - dto 数据传输对象
  - query CQRS查询
- Domain 领域层
  - entity 领域实体
  - valueobject 领域值对象
  - repository 领域资源库
  - domainservice 领域服务
- Infrastructure 基础设施层
  - adapter 适配器
  - ejo 实体json对象
  - po 持久化对象
  - repository 资源库实现
  - mapper 数据映射器

#### Business Rules 业务规则



#### Validation Rules 校验规则



