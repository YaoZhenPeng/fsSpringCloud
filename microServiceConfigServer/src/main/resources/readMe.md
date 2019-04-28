## 项目说明：
- 项目为 配置中心(Config)服务端模块.
- 作用：统一管理配置文件，就是假如有很多微服务，那么每个微服务都有
- yml配置文件。本项目作用就是对这些配置文件进行统一管理
## 配置步骤
- 1、在pom中添加jar包，  查看   Spring Cloud Config 配置中心服务端相关
- 2、添加配置application.yml， 具体查看其中注解
- 3、创建启动类，  具体查看其中注解
## 微服务如何将配置文件给本项目管理
- 参考一个微服务例子   microServiceConfigClient ， 具体参考例子当中的readMe.md文件说明
## 当把以上的说明全部搞明白在看这下面
### 以上我们配置了微服务的配置文件统一管理，当我们更新GitHub中的配置文件内容后，服务是否
### 及时的更新配置内容呢? 答案是不会，只有重启服务才会读取新配置
### 希望在不重启微服务的情况下更新配置可以使用 Spring Cloud Bus 来实现配置的自动更新
- Spring Cloud Bus 被国内很多都翻译为消息总线。可以将它理解为管理和传播所有
- 分布式项目中的消息即可，其实本质是利用了MQ的广播机制在分布式的系统中传播消息，
- 目前常用的有 Kafka 和 RabbitMQ.利用 Bus 的机制可以做很多的事情，其中对统一管理
- 的配置文件的刷新就是典型的应用场景之一。
### 实现逻辑原理如下：
- 修改配置文件并提交到GitHub后，rabbitMQ发送post方式的/bus-refresh请求给 对应的微服务
- 微服务接收到请求从 管理配置文件的服务更新配置并且改善消息给消息总线
- 消息总线接到消息并通知给其它服务客户端
- 其它服务客户端接收到通知，请求管理配置文件的服务获取最新配置
- 直到所有的服务客户端获取到最新的配置
### 消息总线配置步骤
- 这里使用RabbitMQ,安装方法参考  梦学谷的pdf文件
- 在微服务客户端pom中添加jar包       监听器   Bus与rabbitMQ依赖  参考 microServiceConfigClient 中的pom文件
- 在微服务客户端的 bootstrap.yml 配置文件新增   RabbitMQ配置  消息总线配置   参考 microServiceConfigClient 的bootstrap.yml
### 测试步骤
- 先启动本服务，然后启动事例服务 microServiceConfigClient，这时microServiceConfigClient是获取的Git上的配置
- 然后修改Git上 microServiceConfigClient 的配置，要使配置生效我们用 POSTMAN工具发送POST请求http://localhost:5001/actuator/bus-refresh到microServiceConfigClient
- microServiceConfigClient 服务就会重新从Git上从新获取配置。
- 可以访问 com.example.fs.controller.ConfigClientController 里方法
### 特殊点
- 如果数据源采用Druid,更改数据源的配置不会立即生效，需要增加数据源的配置方式就可以，如下
- 参考 com.example.fs.config.DruidConfig  其中@RefreshScope注解的方法，就可以刷新数据源配置
