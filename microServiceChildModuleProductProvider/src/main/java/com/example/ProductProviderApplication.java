package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 微服务相关：
 *       @EnableEurekaClient  表明当前为  Eureka 微服务客户端
 */
@EnableEurekaClient
@MapperScan(basePackages = "com.example.fs.mapper")//扫描所有Mapper接口
@SpringBootApplication
public class ProductProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductProviderApplication.class, args);
    }
}
