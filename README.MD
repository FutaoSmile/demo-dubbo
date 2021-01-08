### # 模块之间的关系

* demo-dubbo-api 定义与存放API-Service和Model
* demo-dubbo-order 提供对于`demo-dubbo-api`中order部分的实现，并暴露dubbo服务
    * 依赖`demo-dubbo-api`
* demo-dubbo-user 提供对于`demo-dubbo-api`中user部分的实现，并暴露dubbo服务
    * 依赖`demo-dubbo-api`
* demo-dubbo-web WEB端 暴露对外的Restful接口，不直接依赖`demo-dubbo-order`和`demo-dubbo-user`,而是通过dubbo-RPC的方式调用远程服务。
    * 依赖`demo-dubbo-api`


### Next http://dubbo.apache.org/zh/docs/v2.7/user/examples/events-notify/