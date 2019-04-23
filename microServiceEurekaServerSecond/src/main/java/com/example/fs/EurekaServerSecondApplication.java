package com.example.fs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *  @EnableEurekaServer 标识 Eureka Server 微服务注册中心
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerSecondApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerSecondApplication.class,args);
    }
}
