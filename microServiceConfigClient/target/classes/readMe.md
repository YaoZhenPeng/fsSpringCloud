## 项目说明
- 本项目是一个简单的微服务，主要是演示如何将配置文件给 配置中心(Config)服务端模块 microServiceConfigServer  来管理的
## 配置步骤
- 1、在pom中添加jar包  ，查看   Spring Cloud Config 配置中心客户端相关
- 2、将配置文件上传到  配置中心(Config)服务端模块  中定义的git仓库
- 3、添加配置文件 application.yml 其中的内容很也没什么用，基本还是以git仓库
- 里的配置文件为主
- 说明：application.yml是用户级别的配置，bootstrap.yml是系统级别的配置，优先级更高而且不会被覆盖
- 4、添加配置文件 bootstrap.yml  查看其中有相关注解
- 5、配置完成了，想要查看是否获取到对应配置，查看项目中  ConfigClientController 
- 其他微服务想要将配置文件 给   配置中心(Config)服务端模块 microServiceConfigServer
- 来管理，参照本项目例子即可。
- 6、每个微服务修改配置文件后无需重启可生效的配置，参照 microServiceConfigServer中的readMe.md文件中
- 的 ‘微服务如何将配置文件给本项目管理’部分
