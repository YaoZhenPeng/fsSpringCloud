### 项目介绍
- fsSpringCloud是建立一个空的工程
### 项目内容
- 这个空的工程里面保存的都是一个个module工程，即所谓的微服务相关的工程
### 项目启动步骤
- 1启动 microServiceConfigServer ，是管理所有工程的配置文件的,所有工程都要通过它获取配置。所以这个工程必须最先启动
- 它是如何管理所有工程配置文件的，具体看它的readMe说明。其它工程又是如何通过它来获取配置的 可以参考事例工程 microServiceConfigClient 具体查看
- 其中的readMe说明。
- 2启动 microServiceEurekaServerFirst、microServiceEurekaServerSecond，这两个工程都是微服务注册中心，两个功能一样，都是提供微
- 服务之间交流的平台即微服务通过它可以互相访问调用。两个相当于做到了简单的集群配置。
- 3启动 microServiceChildModuleProductProvider ，是具体业务的服务提供者，相当于淘宝里有订单和商品，那么它就是订单服务或者商品服务。真实项目会
- 有许许多多这样的服务，这一个作为事例。
- 4启动 microServiceChildModuleProductConsumer_Feign或者microServiceChildModuleProductConsumer_Ribbon，是用于调用服务提供者的工程，可以称为服务
- 的消费者,两者作用是一样，我们选择其中一个就好。我们知道一个淘宝页面可能都要展示订单信息和商品信息，而信息同时位于两个不同的服务提供者。
- 可以将它理解为页面展示工程。这两个工程不同之处，在于使用技术不同，其中Feign相对简单。
- 5启动 microServiceChildModuleHystrixDashboard，是对调用服务的压力进行检测。它是以折线图等可视化展示一个服务被调用的压力。在实际中如果发现某个服务
- 压力特别大，可以增加其部署的服务器，减缓压力。
- 6启动 microServiceZuulGateWay ,是对外部访问时统一路口作用，因为不同的服务可能就有不同的访问端口，这样地址就不统一，它就是使调用的地址形式达到统一，
相当于一个路由器，访问时通过它在去调用不同的服务。它还有一个作用就是调用时做一些校验如登录校验。
- 7其它 microServiceChildModuleCommon ， 是主要写一些实体类的工程，只要其它工程有用到它的实体类，就要在maven中将它导入。
- microServiceFatherModule ，是管理公共的jar包的工程，其它工程都要继承它，这样就不要重复写这些常用的jar包。
### 目前的服务提供者
- 事例服务： microServiceChildModuleProductProvider
- 电子流（基于activiti）： microServiceChildModuleActivity