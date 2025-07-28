# Arcus Common Starter WebFlux

Arcus Project Webflux 项目的通用组件


## 功能列表

- 全局的异常处理 : ArcusWebFluxGlobalExceptionHandler
- 定义校验错误类型


## FAQ
- **为什么不使用全局返回对象**

  Webflux项目的代码因为使用Mono和Flux作为返回的对象，不适合去做全局的拦截返回。

  对于userinterface的返回对象，建议使用common项目中 ArcusRestResponseBody 进行封装。

  这样在编写openapi文档的时候也不需要做全局的封装，提供了项目的灵活性。