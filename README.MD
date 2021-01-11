> 项目来源:
>
> 坑爹的公司项目用Dubbo+Freemarker+Layui服务端渲染。
> 
> 钱难赚，屎难吃。
> 
> 学习中...

### # 模块之间的关系

* demo-dubbo-api 定义与存放API-Service和Model
* demo-dubbo-order 提供对于`demo-dubbo-api`中order部分的实现，并暴露dubbo服务
    * 依赖`demo-dubbo-api`
* demo-dubbo-user 提供对于`demo-dubbo-api`中user部分的实现，并暴露dubbo服务
    * 依赖`demo-dubbo-api`
* demo-dubbo-web WEB端 暴露对外的Restful接口，不直接依赖`demo-dubbo-order`和`demo-dubbo-user`,而是通过dubbo-RPC的方式调用远程服务。
    * 依赖`demo-dubbo-api`

### # 技术

* JDK 1.8
* Maven
* SpringBoot
* Dubbo
  * Zookeeper
* Freemarker (demo-dubbo-web)

### # 开发过程:
1. 先在`demo-dubbo-api`中定义Model和Service接口。
2. 再在服务提供者`demo-dubbo-order`/`demo-dubbo-user`中实现步骤1中定义的接口。
3. 将步骤2的接口实现通过dubbo暴露出来(标记`@org.apache.dubbo.config.annotation.Service`)。
4. 在`demo-dubbo-web`中使用`org.apache.dubbo.config.annotation.Reference`注入在`demo-dubbo-api`中定义的接口，dubbo将自动调用相应的实现。



### Next http://dubbo.apache.org/zh/docs/v2.7/user/examples/events-notify/