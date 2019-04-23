package com.example.fs.controller;

import com.example.fs.model.Product;
import com.example.fs.service.ProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductFeignController_Consumer {

    @Autowired
    private ProductClientService productClientService;


    @RequestMapping(value = "/consumerFeign/product/get/{id}",method = RequestMethod.GET)
    public Product get(@PathVariable("id") Long id)
    {
        System.out.println("sdfsd");
        Product p = productClientService.get(id);
        System.out.println(p);
        return p;
    }
}
