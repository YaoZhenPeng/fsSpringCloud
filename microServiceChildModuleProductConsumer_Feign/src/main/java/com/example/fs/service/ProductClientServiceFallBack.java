package com.example.fs.service;

import com.example.fs.model.Product;
import org.springframework.stereotype.Component;

/**
 *  Feign 熔断器 Hystrix 处理类
 *  微服务接口调用异常处理类：当微服务调用接口失败时，会执行当前类对应接口的重写方法。
 */
@Component
public class ProductClientServiceFallBack implements ProductClientService{

    @Override
    public Product get(Long id) {
        return new Product(id,"无产品数据","无效的数据库");
    }
}
