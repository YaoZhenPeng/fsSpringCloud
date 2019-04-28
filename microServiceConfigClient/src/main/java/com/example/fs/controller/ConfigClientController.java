package com.example.fs.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  通过@Value("${spring.application.name}")获取配置，当配置文件更改时 需要加 @RefreshScope 才能获取到最新的配置
 */
@RefreshScope
@RestController
public class ConfigClientController {
    //会从github中的 microServiceConfigApplication.yml 中获取
    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private String port;

    //请求访问
    @RequestMapping("/config")
    public String getConfig() {
        String content = "applicationName:" + applicationName + ",port:" + port;
        System.out.println("content:" + content);
        return content;
    }
}
