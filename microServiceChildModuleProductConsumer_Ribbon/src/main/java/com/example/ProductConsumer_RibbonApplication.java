package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 微服务注解；
 *       @EnableEurekaClient  表明当前为  Eureka 微服务客户端
 */
@EnableEurekaClient
@SpringBootApplication
public class ProductConsumer_RibbonApplication {

    public static void main(String[] args) {
        System.out.println("sdfsdf");
        SpringApplication.run(ProductConsumer_RibbonApplication.class, args);
    }
}
