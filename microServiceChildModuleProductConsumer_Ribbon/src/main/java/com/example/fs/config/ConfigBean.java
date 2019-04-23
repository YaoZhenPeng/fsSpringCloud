package com.example.fs.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//@Configuration  表明是个配置文件，启动时会加载
@Configuration
public class ConfigBean {


    /**
     * 微服务相关类
     *
     * @Bean
     *     向容器中添加 RestTemplate 组件，直接通过此组件可调用 REST 接口
     * @LoadBalanced
     *      表示这个 RestTemplate 开启负载均衡，在调用服务提供者的接口时，
     *      可使用服务名称替代真实IP地址。服务名称 就是服务提供都在application.yml中
     *      配置的 spring.application.name 属性的值。
     *      （实现负载均衡时会有多个相同服务名称的服务部署在不同服务器上，根据Ribbon的负载均衡算法
     *        找到最优的服务，然后调用相应接口
     *      ）
     *
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
