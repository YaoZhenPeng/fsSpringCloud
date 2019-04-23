package com.example.fs.controller;

import com.example.fs.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductRibbonController_Consumer {

    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    //修改为 Eureka注册中 服务提供者的地址
    private static final String REST_URL_PREFIX = "http://microServiceProductProvider";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumerRibbon/product/get/{id}")
    public Product get(@PathVariable("id") Long id) {
        System.out.println("kdslf");
        return restTemplate.getForObject(REST_URL_PREFIX + "/product/get/" + id, Product.class);
    }
}
