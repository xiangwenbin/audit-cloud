# 云审计项目工程
## 业务主流程核心api模块 audit-cloud-core-api
* 被 service，webapp 工程所依赖,客户端通过 该工程的api接口，调用注册在eureka上的服务
* api.service.feign feign接口（feign接口命名规则 跟restful controller 对象名要保持一致）
* api.utils 公共工具类
* api.model.vo 对外数据对象

## 业务主流程核心服务模块 audit-cloud-core-service
* 业务主流程服务提供者，服务注册在eureka注册中心
* provider.controller 对外restful http api
* provider.model.po 持久层对象
* provider.model.service 业务逻辑服务层
* provider.utils 工具类

## 审计帐套api模块 audit-cloud-accounts-api
* 被 service，webapp 工程所依赖,客户端通过 该工程的api接口，调用注册在eureka上的服务
* api.service.feign feign接口（feign接口命名规则 跟restful controller 对象名要保持一致）
* api.utils 公共工具类
* api.model.vo 对外数据对象

## 审计帐套服务模块 audit-cloud-accounts-service
* 帐套服务提供者，服务注册在eureka注册中心
* provider.controller 对外restful http api
* provider.model.po 持久层对象
* provider.model.service 业务逻辑服务层
* provider.utils 工具类

## 审计底稿api模块 audit-cloud-template-api
* 被 service，webapp 工程所依赖,客户端通过 该工程的api接口，调用注册在eureka上的服务
* api.service.feign feign接口（feign接口命名规则 跟restful controller 对象名要保持一致）
* api.utils 公共工具类
* api.model.vo 对外数据对象

## 审计底稿服务模块 audit-cloud-template-service
* 底稿服务提供者，服务注册在eureka注册中心
* provider.controller 对外restful http api
* provider.model.po 持久层对象
* provider.model.service 业务逻辑服务层
* provider.utils 工具类

## pc应用模块 audit-cloud-webapp
* 依赖api模块，通过api模块的feign接口,调用具体服务
* webapp.controller 终端调用api接口
* webapp.interceptor拦截器
* webapp.service 较复杂业务逻辑层 

## 其他模块 audit-cloud-wap audit-cloud-backend 等
* 各平台应用子模块，根据需求建立，同 tax-cloud-webapp


## 工程测试
* 确保gateway-service application.properties 含 该服务路由映射
* 启动audit-cloud-*-service ，注册该服务到eureka
* 启动audit-cloud-webapp 测试接口localhost:8081/feigin/test/{text} 