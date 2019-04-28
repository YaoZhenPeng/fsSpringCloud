### 项目介绍
- 本项目是对微服务消费者调用服务提供堵的准实时的调用监控
- Hystrix除务消了为微服费者调用微服务提供者提供熔断机制(查看Feign配置消费者消费者工程说明)
- Hystrix还提供了准实时的调用监控（Hystrix Dashboard）,Hystrix会持续地记录所有通过Hystrix
- 发起的请求的执行信息，并以统计报表和图形的形式展示给用户，包括每秒执行多少请求成功，多少失败等。
### 配置步骤
- 导入jar包，查看pom中 Hystrix Dashboard 相关
- 编写配置文件  查看  application.yml 其中就配置了服务端口
- 编写启动类
- 访问 http://localhost:9001/hystrix 效果页面出现 豪猪
### 为要被监控的服务(当前工程配置在了microServiceChildModuleProductConsumer_Feign)添加配置
- 在需要监控的服务工程的 pom.xml 中添加相关包查看 监控相关
- 注意;目前已经将配置文件 统一管理
    - 具休查看 项目microServiceConfigServer 、microServiceConfigClient是如何配置的  
- 为需要监控的服务工程 application.yml 配置中添加暴露端点  查看 management节点 
- 在启动类开启服务监控，查看启动类  微服务的服务调用监控 com.example.ProductConsumer_FeignApplication
### 启动使用(监控的使用参数梦学谷中有详细说明)