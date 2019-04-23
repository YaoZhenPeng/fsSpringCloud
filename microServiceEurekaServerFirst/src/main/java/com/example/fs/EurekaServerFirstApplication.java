package com.example.fs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 微服务相关
 *      @EnableEurekaServer 标识一个Eureka Server 微服务注册中心
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerFirstApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerFirstApplication.class, args);
    }
}
