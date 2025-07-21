# User Interface Naming - 用户接口层命名规范

用户接口层的命名规范定义

## View Controller - 视图控制器

视图控制器是前端组件（Vue，React，App）和后端交互的接口，遵循页面对应控制器的原则，保证每个路由页面都只对应一个控制器，以方便各方查询对应的接口。

### 控制器命名格式： 

`{RouteUniqueName}ViewController`

RouteUniqueName 为前端路由的页面唯一标识，代表一个页面（或一组页面，比如用户管理的增删改查都是同一个路由）



## RESTful Controller - REST风格控制器

基于RESTful 软件架构风格，通过HTTP协议标准方法（如GET，POST，PUT，DELETE等）来操作资源，核心思想是将系统中的数据和功能抽象为 “资源”，并通过 URI（统一资源标识符）标识资源，客户端通过请求资源的某种表现形式（如 JSON、XML 等）来实现与服务器的交互，且交互过程中无需保存客户端状态（即 “无状态”）。

### 控制器命名格式

`{ResourceName}RESTfulController`

Resource Name为资源的名称



## Operations Controller - 运维控制器

运维业务使用的控制器

`{Function}OpsController`



## Open API Controller - 开放应用接口控制器

开放应用接口控制器用于对外提供服务的接口，通常用于第三方应用集成。

`{Function}OpenAPIController`

