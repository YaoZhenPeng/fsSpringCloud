package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 微服务注解；
 *          @EnableFeignClients  标记指定包下 @FeignClient 注解的接口 ， 并生成此接口的代理对象
 *          @EnableEurekaClient  表明当前为  Eureka 微服务客户端
 * 微服务的服务调用监控：
 *          @EnableHystrix  开启 Hystrix 的熔断机制
 */

@EnableHystrix
@EnableFeignClients(basePackages = {"com.example.fs.service"})
@EnableEurekaClient
@SpringBootApplication
public class ProductConsumer_FeignApplication {

    public static void main(String[] args) {
        System.out.println("sdfsdf");
        SpringApplication.run(ProductConsumer_FeignApplication.class, args);
    }
}
