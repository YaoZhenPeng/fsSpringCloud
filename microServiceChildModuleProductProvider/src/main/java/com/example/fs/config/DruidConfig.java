package com.example.fs.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 刷新数据源
 * 不要在这个类上加 @RefreshScope 会报错
 */
@Configuration
public class DruidConfig {

    @RefreshScope //刷新数据源
    @ConfigurationProperties(prefix = "spring.datasource")//绑定数据源
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }
}
