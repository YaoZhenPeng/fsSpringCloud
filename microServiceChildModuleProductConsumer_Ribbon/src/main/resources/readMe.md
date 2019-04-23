### 工程介绍
- 工程是微服务的消费者：作用就是从服务注册中心调用服务提供者的接口服务，
- 工程采用 Ribbon+RestTemplate 方式调用服务提供者的接口及实现负载均衡，具体实现如下：
### 如何实现服务调用与负载均衡
- （1）导入jar,查看pom中 微服务相关
- （2）编辑配置文件，查看application.yml文件中的 eureka 内容
- （3）编写配置类，查看com.example.fs.config.ConfigBean中微服务相关类
- （4）建一个controller进行调用，查看com.example.fs.controller.ProductRibbonController_Consumer
- （5）在启动类上加相关注解，查看启动类
- 根据步骤一步步看，其中都有注解说明
### 说明
- 本微服务消费者工程采用 Ribbon+RestTemplate 方式调用服务，及实现了以上内容，
- 由于 Feign 方式更加方便，所以 本工程不在增加其他功能，如要查看其他功能参考梦学谷的pdf文件