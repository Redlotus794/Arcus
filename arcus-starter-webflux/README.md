# Arcus Starter WebFlux

Arcus Project中如果有使用webflux的项目，可以集成此项目

## 版本信息

```text
Java : 21
Spring Cloud: 2025.0.0
Spring Boot: 3.5.0
```

## 功能列表

- 全局的异常处理 : ArcusWebFluxGlobalExceptionHandler


## FAQ
- **为什么不使用全局返回对象**

  Webflux项目的代码因为使用Mono和Flux作为返回的对象，不适合去做全局的拦截返回。

  对于userinterface的返回对象，建议使用common项目中 ArcusRestResponseBody 进行封装。

  这样在编写openapi文档的时候也不需要做全局的封装，提供了项目的灵活性。