### 微服务工程介绍
- 本工程是微服务的提供者，就是主要对数据库进行操作，一个庞大的工程有许多的微服务提供者，本例只是一个例子
- 服务的提供者都要注册要微服务注册中心(Eureka),并且对压力大的服务提供者还要配置在多个
- 服务器，全部都要注册到微服务注册中心(Eureka)，微服务的消费者根据负载均衡算法选择最优的
- 服务进行访问即负载均衡(参考微服务消费者中如何实现负载均衡)
### 如何实现微服务的提供者并注册到微服务注册中心
- （1）导入jar,查看pom中 微服务相关
- 注意;目前已经将配置文件 统一管理
    - 具休查看 项目microServiceConfigServer 、microServiceConfigClient是如何配置的
- （2）编辑配置文件，查看 application.yml(配置文件统一管理后，需要找到对应的配置文件)文件中的 eureka 内容
- （5）在启动类上加相关注解，查看启动类
- 根据步骤一步步看，其中都有注解说明
#### mybatis连接数据库，数据源Druid配置
- (1)导入jar，查看pom中  'mybatis 启动器'、'数据源'
- (2)添加mybatis配置文件：mybatis/mybatis.cfg.xml，和对应表的xml文件如microServiceChildModuleProductProvider 的mybatis/mapper/ProductMapper.xml 
- 、com.example.fs.mapper.ProductMapper
- (3)启动类加上扫描Mapper的注解，查看启动类
- (4)编辑系统配置文件，查看其中  mybatis   、 spring.datasource相关配置
#### idea实现电子流开发具体步骤如下：
- 1。idea需要添加actiBPM插件（目的是用于绘制工作流图），绘制电子流程图 如processes/LeaveProcess.xml
- 2。添加jar包， 在pom中添加   activiti 电子流相关
- 3。编辑系统配置文件, 查看其中 spring.activiti
- 4。绘制的流程图怎么与activiti的配置关联起来
- 
###  activiti使用说明.md
